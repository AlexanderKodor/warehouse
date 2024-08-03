package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.dto.BlankDTO;
import com.alex.warehouse.dto.RequestDTO;
import com.alex.warehouse.entity.*;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.mapping.BlankMap;
import com.alex.warehouse.mapping.RequestMap;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RequestServiceImpl implements BaseService<Request> {
    private BaseDAO<Request> baseDAO;
    private BaseDAO<Blank> baseDAOBlank;
    private BaseDAO<Employee> baseDAOEmployee;

    public RequestServiceImpl(BaseDAO<Request> baseDAO, BaseDAO<Blank> baseDAOBlank, BaseDAO<Employee> baseDAOEmployee) {
        this.baseDAO = baseDAO;
        this.baseDAOBlank = baseDAOBlank;
        this.baseDAOEmployee = baseDAOEmployee;
    }

    @Override
    @Transactional
    public List<Request> getAllEntity() {
        return baseDAO.getAllEntity();
    }

    @Override
    @Transactional
    public Request saveEntity(Request request) {
        return baseDAO.saveEntity(request);
    }

    @Override
    @Transactional
    public Request getEntity(int id) {
        return baseDAO.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        baseDAO.deleteEntity(id);
    }

    @Transactional
    public Blank requestToBlank(RequestDTO requestDTO){
        if (requestDTO.getId() == 0) {
            throw new NoSuchDataException("Во входящих данных отсутствует id.");
        }
        Request requestOld = baseDAO.getEntity(requestDTO.getId());
        if (requestOld == null) {
            throw new NoSuchDataException("Заявка с id - " + requestDTO.getId() + " отсутствует.");
        }
        Request request = requestOld;
        request.setStatus(new Status(requestDTO.getStatus_id()));
        BlankDTO blankDTO = null;
        if (request.getStatus().getId() == 3) {
            if (baseDAOEmployee.getEntity(requestDTO.getEmployee_id()).getRole().getId() == 1
                    || baseDAOEmployee.getEntity(requestDTO.getEmployee_id()).getRole().getId() == 2) {
                request.setEmployee(requestOld.getEmployee());
                blankDTO = new BlankDTO();
                blankDTO.setRequest_id(requestDTO.getId());
                blankDTO.setStatus_id(1);
            } else {
                throw new NoSuchDataException("У вас недостаточно прав.");
            }
        } else {
            throw new NoSuchDataException("Выбран не верный статус");
        }
        request.setDateCreate(requestOld.getDateCreate());
        request.setDateChange(LocalDateTime.now());
        new RequestServiceImpl(baseDAO,baseDAOBlank,baseDAOEmployee).saveEntity(request);
        Blank blank = BlankMap.mapping(blankDTO);
        blank.setDateCreate(LocalDateTime.now());
        blank.setEmployee(new Employee(requestDTO.getEmployee_id()));
        blank.setDriver(new Driver(1));
        blank.setTanker(new Tanker(1));
        return baseDAOBlank.saveEntity(blank);
    }
}

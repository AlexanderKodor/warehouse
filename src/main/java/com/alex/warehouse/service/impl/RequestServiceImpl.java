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
        List<Request> requestList = baseDAO.getAllEntity();
        if (requestList.isEmpty()) {
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return requestList;
    }

    @Override
    @Transactional
    public Request saveEntity(Request request) {
        switch (request.getStatus().getId()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                throw new NoSuchDataException("У вас не достаточно прав для установки данного статуса заявки.");
            default:
                throw new NoSuchDataException("Неизвестный статус.");
        }
        request.setDateCreate(LocalDateTime.now());
        return baseDAO.saveEntity(request);
    }

    @Override
    @Transactional
    public Request getEntity(int id) {
        Request request = baseDAO.getEntity(id);
        if (request == null) {
            throw new NoSuchDataException("Заявка с id - " + id + " отсутствует.");
        }
        return request;
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        Request request = baseDAO.getEntity(id);
        if (request == null) {
            throw new NoSuchDataException("Заявка с id - " + id + " отсутствует.");
        }
        baseDAO.deleteEntity(id);
    }

    /**
     * Устанавливает статус заявки "выполнена", одновременно создаёт котировку с прикреплением к ней заявки.
     * @param requestDTO Сокращённая сущность заявки со статусом "выполена".
     * @return           Полноценная сущность котировки со статусом "в работе".
     */
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

    public Request updateEntity(RequestDTO requestDTO){
        if (requestDTO.getId() == 0) {
            throw new NoSuchDataException("Во входящих данных отсутствует id.");
        }
        Request requestOld = baseDAO.getEntity(requestDTO.getId());
        if (requestOld == null) {
            throw new NoSuchDataException("Заявка с id - " + requestDTO.getId() + " отсутствует.");
        }
        Request request = RequestMap.mapping(requestDTO);
        request.setDateCreate(requestOld.getDateCreate());
        return baseDAO.saveEntity(request);
    }
}

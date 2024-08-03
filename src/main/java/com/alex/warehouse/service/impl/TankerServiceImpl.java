package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.impl.TankerDaoJpa;
import com.alex.warehouse.entity.Tanker;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TankerServiceImpl implements BaseService<Tanker> {
    private TankerDaoJpa tankerDAO;

    public TankerServiceImpl(TankerDaoJpa tankerDAO) {
        this.tankerDAO = tankerDAO;
    }

    @Override
    public List<Tanker> getAllEntity() {
        List<Tanker> tankerList = tankerDAO.findAll();
        if (tankerList.isEmpty()) {
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return tankerList;
    }

    @Override
    public Tanker saveEntity(Tanker tanker) {
        return tankerDAO.save(tanker);
    }

    @Override
    public Tanker getEntity(int id) {
        Optional<Tanker> optional = tankerDAO.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        else {
            throw new NoSuchDataException("Бензовоз с id - " + id + " отсутствует.");
        }
    }

    @Override
    public void deleteEntity(int id) {
        Optional<Tanker> optional = tankerDAO.findById(id);
        if (optional.isPresent()) {
            tankerDAO.deleteById(id);
        }
        else {
            throw new NoSuchDataException("Бензовоз с id - " + id + " отсутствует.");
        }
    }
}

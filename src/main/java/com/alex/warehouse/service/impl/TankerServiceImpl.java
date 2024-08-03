package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.impl.TankerDAOImpl;
import com.alex.warehouse.entity.Tanker;
import com.alex.warehouse.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TankerServiceImpl implements BaseService<Tanker> {
    private TankerDAOImpl tankerDAO;

    public TankerServiceImpl(TankerDAOImpl tankerDAO) {
        this.tankerDAO = tankerDAO;
    }

    @Override
    public List<Tanker> getAllEntity() {
        return tankerDAO.findAll();
    }

    @Override
    public Tanker saveEntity(Tanker tanker) {
        return tankerDAO.save(tanker);
    }

    @Override
    public Tanker getEntity(int id) {
        Optional<Tanker> optional = tankerDAO.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public void deleteEntity(int id) {
        tankerDAO.deleteById(id);
    }

    //    private BaseDAO<Tanker> baseDAO;
//    @Autowired
//    public TankerServiceImpl(BaseDAO<Tanker> baseDAO) {
//        this.baseDAO = baseDAO;
//    }
//
//    @Override
//    @Transactional
//    public List<Tanker> getAllEntity() {
//        return baseDAO.getAllEntity();
//    }
//
//    @Override
//    @Transactional
//    public Tanker saveEntity(Tanker tanker) {
//        return baseDAO.saveEntity(tanker);
//    }
//
//    @Override
//    @Transactional
//    public Tanker getEntity(int id) {
//        return baseDAO.getEntity(id);
//    }
//
//    @Override
//    @Transactional
//    public void deleteEntity(int id) {
//        baseDAO.deleteEntity(id);
//    }
}

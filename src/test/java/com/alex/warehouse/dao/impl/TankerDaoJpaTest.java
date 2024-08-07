package com.alex.warehouse.dao.impl;

import com.alex.warehouse.entity.Tanker;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TankerDaoJpaTest {
    @Autowired
    EntityManager entityManager;

    @Autowired
    TankerDaoJpa tankerDAO;

    @Test
    void findById(){
        Tanker tanker = new Tanker("к555кк58","q73y98rtq34rg08");
        tankerDAO.save(tanker);
        Optional<Tanker> tankerDB = tankerDAO.findById(1);
        Assertions.assertEquals(tankerDB.get().getNumber(), tankerDAO.findById(1).get().getNumber());
    }
}

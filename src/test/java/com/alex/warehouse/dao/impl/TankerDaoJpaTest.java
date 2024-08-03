package com.alex.warehouse.dao.impl;

import com.alex.warehouse.entity.Tanker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TankerDaoJpaTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    TankerDaoJpa tankerDAO;

    @Test
    void findById(){
        Optional<Tanker> tanker = tankerDAO.findById(1);
        Assertions.assertEquals(tanker.get(), tankerDAO.findById(1).get());
    }
}

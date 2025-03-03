package com.alex.warehouse.dao.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Driver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(DriverDAOImpl.class)
public class DriverDAOImplTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BaseDAO<Driver> driverDAOImpl;

    @Test
    void getAllEntity_success(){
        Driver driver1 = new Driver(1, "Егор", "Сидоров","89279272727");
        Driver driver2 = new Driver(2, "Семён", "Абрикосов","89279277272");
        List<Driver> expectedDrivers = List.of(driver1, driver2);

        entityManager.merge(driver1);
        entityManager.merge(driver2);
        List<Driver> actualDrivers = driverDAOImpl.getAllEntity();

        assertEquals(expectedDrivers.size(), actualDrivers.size());
        assertEquals(expectedDrivers, actualDrivers);
    }
}

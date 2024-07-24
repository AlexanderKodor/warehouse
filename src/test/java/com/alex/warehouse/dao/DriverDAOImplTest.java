package com.alex.warehouse.dao;

import com.alex.warehouse.entity.Driver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DriverDAOImplTest {
    @Mock
    private EntityManager entityManager;
    @Mock
    Query query;

    @Test
    void getAllEntity_success(){
        Driver driver1 = new Driver(1, "Егор", "Сидоров","89279272727");
        Driver driver2 = new Driver(1, "Семён", "Абрикосов","89279277272");
        List<Driver> driverList = new ArrayList<>();
        driverList.add(driver1);
        driverList.add(driver2);

        when(entityManager.createQuery(anyString())).thenReturn(query);
        when(query.getResultList()).thenReturn(driverList);

        query = entityManager.createQuery(anyString());
        List<Driver> queryList = query.getResultList();

        Assertions.assertEquals(driverList.size(), queryList.size());
//        Assertions.assertEquals(driverList.get(0),queryList.get(0)); //под вопросом
        Assertions.assertTrue(queryList.contains(driver1));
        Assertions.assertTrue(queryList.contains(driver2));

        verify(query).getResultList();
        verify(entityManager).createQuery(anyString());
    }
}

package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.dao.impl.BlankDAOImpl;
import com.alex.warehouse.dao.impl.EmployeeDAOImpl;
import com.alex.warehouse.dto.BlankDTO;
import com.alex.warehouse.entity.*;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.mapping.BlankMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class BlankServiceImplTest {

    @InjectMocks
    private BlankServiceImpl blankService;
    @Mock
    private BlankDAOImpl baseDAO;
    @Mock
    private EmployeeDAOImpl baseDAOEmployee;
    @Mock
    private BaseDAO<Invoice> baseDAOInvoice;

    @Test
    void blankToInvoice_success(){
        BlankDTO blankDTO = new BlankDTO(1,1,1,1,3,1);
        Blank blank = BlankMap.mapping(blankDTO);
        Invoice expectedInvoice = new Invoice(1, blank, "", new Nomenclature(), 1000,
                new Company(), new Employee(2), LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now(),new Status(1));
        Employee employee = new Employee(1,"","","", new Role(1,""));

        when(baseDAO.getEntity(blankDTO.getId())).thenReturn(blank);
        when(baseDAOEmployee.getEntity(blankDTO.getEmployee_id())).thenReturn(employee);
        when(baseDAO.saveEntity(any(Blank.class))).thenReturn(blank);
        when(baseDAOInvoice.saveEntity(any(Invoice.class))).thenReturn(expectedInvoice);

        Invoice invoice = blankService.blankToInvoice(blankDTO);

        assertNotNull(invoice);

        verify(baseDAO).getEntity(blankDTO.getId());
        verify(baseDAOEmployee).getEntity(blankDTO.getEmployee_id());
        verify(baseDAO).saveEntity(any(Blank.class));
        verify(baseDAOInvoice).saveEntity(any(Invoice.class));

    }
    @Test
    void blankToInvoice_failed(){
        BlankDTO blankDTO = new BlankDTO(1,1,1,1,3,3);
        Blank blank = BlankMap.mapping(blankDTO);
        Employee employee = new Employee(3,"","","", new Role(3,""));

        when(baseDAO.getEntity(blankDTO.getId())).thenReturn(blank);
        when(baseDAOEmployee.getEntity(blankDTO.getEmployee_id())).thenReturn(employee);

        assertThrows(NoSuchDataException.class, () -> blankService.blankToInvoice(blankDTO));

        verify(baseDAO).getEntity(blankDTO.getId());
        verify(baseDAOEmployee).getEntity(blankDTO.getEmployee_id());

    }
}

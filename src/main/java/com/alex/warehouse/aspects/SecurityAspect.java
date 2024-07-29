package com.alex.warehouse.aspects;

import com.alex.warehouse.dto.BlankDTO;
import com.alex.warehouse.dto.RequestDTO;
import com.alex.warehouse.entity.Employee;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.BaseService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SecurityAspect {
    BaseService<Employee> baseService;

    public SecurityAspect(BaseService<Employee> baseService) {
        this.baseService = baseService;
    }

    @Before("com.alex.warehouse.aspects.MyPointcuts.accessFromRequestRestControllerRequestToBlank()")
    public void beforeAccessFromRequestRestControllerRequestToBlank(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        for(Object obj:args){
            if(obj instanceof RequestDTO){
                RequestDTO requestDTO = (RequestDTO) obj;
                if (baseService.getEntity(requestDTO.getEmployee_id()).getRole().getId()>2){
                    throw new NoSuchDataException("У вас не достаточно прав на закрытие заявки.");
                }
            }
        }
        System.out.println("Сработал секьюрити аспект");
    }
    @Before("com.alex.warehouse.aspects.MyPointcuts.accessFromBlankRestControllerBlankToInvoice()")
    public void beforeAccessFromBlankRestControllerBlankToInvoice(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        for(Object obj:args){
            if(obj instanceof BlankDTO){
                BlankDTO blankDTO = (BlankDTO) obj;
                if (baseService.getEntity(blankDTO.getEmployee_id()).getRole().getId()>2){
                    throw new NoSuchDataException("У вас не достаточно прав на закрытие котировки.");
                }
            }
        }
    }
}

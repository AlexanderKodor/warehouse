package com.alex.warehouse.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

    @Pointcut("execution(* com.alex.warehouse.controller.RequestRestController.requestToBlank(*))")
    public void accessFromRequestRestControllerRequestToBlank(){}
    @Pointcut("execution(* com.alex.warehouse.controller.BlankRestController.blankToInvoice(*))")
    public void accessFromBlankRestControllerBlankToInvoice(){}
}

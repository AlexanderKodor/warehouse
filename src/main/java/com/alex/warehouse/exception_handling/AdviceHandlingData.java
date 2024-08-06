package com.alex.warehouse.exception_handling;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceHandlingData {
    /**
     * Вызывается в случае отсутствия данных.
     * @param exception
     * @return Расшифровка неверно предоставленных данных.
     */
    @ExceptionHandler
    public ResponseEntity<HandlingData> incorrectData(NoSuchDataException exception){
        return new ResponseEntity<>(new HandlingData(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    /**
     * Перехватывает иные случаи невозможности предоставления данных при обработке входящего запроса.
     * @param exception
     * @return Расшифровка неверного запроса.
     */
    @ExceptionHandler
    public ResponseEntity<HandlingData> incorrectData(EntityNotFoundException exception){
        return new ResponseEntity<>(new HandlingData(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

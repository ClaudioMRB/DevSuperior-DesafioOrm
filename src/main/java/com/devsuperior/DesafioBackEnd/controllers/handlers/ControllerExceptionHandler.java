package com.devsuperior.DesafioBackEnd.controllers.handlers;

import com.devsuperior.DesafioBackEnd.dto.CustomError;
import com.devsuperior.DesafioBackEnd.services.excecoes.DatabaseException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    //Tratando erros de forma personalizada
    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceAccessException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError error = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> database(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError error = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
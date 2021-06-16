package com.company.librarywebappspring.exception;

import com.company.librarywebappspring.dto.ErrorDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorDto entityNotFoundExceptionHandler(Exception e){

        return ErrorDto.builder()
                .errorCode("404")
                .errorMessage(e.getMessage())
                .timestamp(new Date())
                .build();
    }

}

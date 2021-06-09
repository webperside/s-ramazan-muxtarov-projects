package com.company.librarywebappspring.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ModelAndView entityNotFoundExceptionHandler(Exception e){
        return new ModelAndView("redirect:/books?error="+e.getMessage());
    }

}

package com.company.librarywebappspring.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ResponseDto {

    private Date date;
    private String message;
    private Object object;

}

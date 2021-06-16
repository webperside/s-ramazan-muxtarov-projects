package com.company.librarywebappspring.dto.users;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserCreateDto {

    private String name;
    private String surname;
    private String email;
    private String password;
}

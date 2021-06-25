package com.company.librarywebappspring.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestTokenDto {

    private String email;
    private String password;
    private boolean rememberMe;

}

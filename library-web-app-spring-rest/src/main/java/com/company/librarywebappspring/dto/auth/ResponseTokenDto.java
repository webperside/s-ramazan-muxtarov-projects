package com.company.librarywebappspring.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseTokenDto {

    private String accessToken;
    private String refreshToken;

}

package com.company.librarywebappspring.service.inter;

import com.company.librarywebappspring.dto.users.UserCreateDto;
import com.company.librarywebappspring.models.User;

public interface UserService {

    boolean register(UserCreateDto userCreateDto);
}

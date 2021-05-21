package com.company.librarywebappspring.service.impl;

import com.company.librarywebappspring.models.User;
import com.company.librarywebappspring.repository.UserRepository;
import com.company.librarywebappspring.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public boolean register(User user) {
        userRepository.save(user);
        sendEmail(user.getEmail());
        return true;
    }

    private void sendEmail(String email){
        System.out.printf("Email [%s] sent!%n", email);
    }
}

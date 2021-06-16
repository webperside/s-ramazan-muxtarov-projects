package com.company.librarywebappspring.service.impl;

import com.company.librarywebappspring.dto.users.UserCreateDto;
import com.company.librarywebappspring.models.Role;
import com.company.librarywebappspring.models.User;
import com.company.librarywebappspring.repository.RoleRepository;
import com.company.librarywebappspring.repository.UserRepository;
import com.company.librarywebappspring.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean register(UserCreateDto userDto) {
        Role role = roleRepository.findById(2).orElse(null);

//        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User user = User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .password(userDto.getPassword())
                .surname(userDto.getSurname())
                .role(role)
                .build();

//        user.setRole(role);

        userRepository.save(user);
        sendEmail(user.getEmail());
        return true;
    }

    private void sendEmail(String email){
        System.out.printf("Email [%s] sent!%n", email);
    }
}

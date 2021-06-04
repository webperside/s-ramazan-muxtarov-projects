package com.company.librarywebappspring.security;

import com.company.librarywebappspring.models.User;
import com.company.librarywebappspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optUser = userRepository.findByEmail(s);
        UserDetails userDetails = null;
        if(optUser.isPresent()){
            User user = optUser.get();

            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(user.getRole().getName()));

            userDetails = new CustomUserDetail(
                    user,
                    user.getEmail(),
                    user.getPassword(),
                    roles
            ); //digital ocean
            // browser-------->server
            // browser-------->server(tomcat)
            // browser(/books)-------->server
        } else {
            throw new UsernameNotFoundException(String.format("%s user not found", s));
        }
        return userDetails;
    }
}

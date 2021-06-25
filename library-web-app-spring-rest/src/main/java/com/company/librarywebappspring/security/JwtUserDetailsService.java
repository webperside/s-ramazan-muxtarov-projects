package com.company.librarywebappspring.security;

import com.company.librarywebappspring.models.Role;
import com.company.librarywebappspring.models.User;
import com.company.librarywebappspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s).orElseThrow(() ->
                new UsernameNotFoundException(String.format("username %s not found",s)));
        return JwtUser.builder()
                .username(s)
                .password(user.getPassword())
                .authorities(mapRoles(user.getRole()))
                .build();
    }

    private Collection<? extends GrantedAuthority> mapRoles(Role role){
        return Collections.singletonList(new SimpleGrantedAuthority(role.getName()));
    }
}

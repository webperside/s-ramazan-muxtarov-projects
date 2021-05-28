package com.company.librarywebappspring.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);

        // email = hamid -> UserDetailService(user,hamid,sdfkj237486893b,USER)
        // pass  = hamid123 -> fhdsouy2387df
        //
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/books").permitAll()
                .antMatchers("/book-add","/book-edit","/book-delete").hasAuthority("ADMIN")
                .antMatchers("/user-register").anonymous()
                .and().formLogin().defaultSuccessUrl("/books")
                .and().logout().logoutSuccessUrl("/login")
                .and().csrf().disable();
    }
}

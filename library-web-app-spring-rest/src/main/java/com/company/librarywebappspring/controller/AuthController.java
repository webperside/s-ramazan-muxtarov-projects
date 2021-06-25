package com.company.librarywebappspring.controller;

import com.company.librarywebappspring.dto.ResponseDto;
import com.company.librarywebappspring.dto.auth.RequestTokenDto;
import com.company.librarywebappspring.dto.auth.ResponseTokenDto;
import com.company.librarywebappspring.models.User;
import com.company.librarywebappspring.repository.UserRepository;
import com.company.librarywebappspring.security.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/test")
    public String testPOst(@RequestBody RequestTokenDto requestTokenDto){
        return "test";
    }

    @PostMapping("/login2")
    public ResponseDto login(@RequestBody RequestTokenDto requestTokenDto){

        System.out.println(requestTokenDto);

        authenticate(requestTokenDto);

        User user = userRepository.findByEmail(requestTokenDto.getEmail()).get();

        String accessToken = jwtTokenUtil.createAccessToken(user);
        String refreshToken = jwtTokenUtil.createRefreshToken(user, requestTokenDto.isRememberMe());

        ResponseTokenDto responseTokenDto = ResponseTokenDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

        return ResponseDto.builder().object(responseTokenDto).build();
    }

    private void authenticate(RequestTokenDto loginDto) throws AuthenticationException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );
//        try {
//
//        } catch (AuthenticationException e) {
//            e.printStackTrace();
//        }
    }

}

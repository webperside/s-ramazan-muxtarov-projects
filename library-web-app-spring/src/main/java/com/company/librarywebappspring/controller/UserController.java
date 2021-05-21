package com.company.librarywebappspring.controller;

import com.company.librarywebappspring.models.User;
import com.company.librarywebappspring.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @RequestMapping(value = "/user-register", method= RequestMethod.GET)
    @GetMapping("/user-register")
    public ModelAndView userRegisterGet(){
        return new ModelAndView("user-register");
    }

    @PostMapping("/user-register")
    public ModelAndView userRegisterPost(User user){
        userService.register(user);
        return new ModelAndView("redirect:/books");
    }

}

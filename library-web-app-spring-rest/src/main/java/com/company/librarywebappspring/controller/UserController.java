package com.company.librarywebappspring.controller;

import com.company.librarywebappspring.dto.users.UserCreateDto;
import com.company.librarywebappspring.models.User;
import com.company.librarywebappspring.models.UserBook;
import com.company.librarywebappspring.service.inter.UserBookService;
import com.company.librarywebappspring.service.inter.UserService;
import com.company.librarywebappspring.util.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
//    private final UserBookService userBookService;

//    @PostConstruct
//    public void tempUser(){
//        UserCreateDto userCreateDto = new UserCreateDto();
//        userCreateDto.setEmail("hamid@gmail.com");
//        userCreateDto.setPassword("12345");
//        userCreateDto.setName("H");
//        userCreateDto.setSurname("S");
//        userService.register(userCreateDto);
//    }

    @PostMapping("/register")
    public void register(@RequestBody UserCreateDto userCreateDto){
        userService.register(userCreateDto);
    }

//
////    @RequestMapping(value = "/user-register", method= RequestMethod.GET)
//    @GetMapping("/user-register")
//    public ModelAndView userRegisterGet(){
//        return new ModelAndView("user-register");
//    }
//
//    @PostMapping("/user-register")
//    public ModelAndView userRegisterPost(User user){
//        userService.register(user);
//        return new ModelAndView("redirect:/login");
//    }
//
//    @GetMapping("/user-profile")
//    public ModelAndView userProfileGet(ModelAndView mv){
//        List<UserBook> userBookList = userBookService.findAllByUserId(UserUtils.getId());
//        String fullName = UserUtils.getFullName();
//        mv.setViewName("user-profile");
//        mv.addObject("fullName",fullName);
//        mv.addObject("books",userBookList);
//        return mv;
//    }

}

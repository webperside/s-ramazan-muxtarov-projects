package com.company.librarywebappspring.controller;

import com.company.librarywebappspring.models.User;
import com.company.librarywebappspring.models.UserBook;
import com.company.librarywebappspring.service.inter.UserBookService;
import com.company.librarywebappspring.service.inter.UserService;
import com.company.librarywebappspring.util.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserBookService userBookService;

//    @RequestMapping(value = "/user-register", method= RequestMethod.GET)
    @GetMapping("/user-register")
    public ModelAndView userRegisterGet(){
        return new ModelAndView("user-register");
    }

    @PostMapping("/user-register")
    public ModelAndView userRegisterPost(User user){
        userService.register(user);
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/user-profile")
    public ModelAndView userProfileGet(ModelAndView mv){
        List<UserBook> userBookList = userBookService.findAllByUserId(UserUtils.getId());
        String fullName = UserUtils.getFullName();
        mv.setViewName("user-profile");
        mv.addObject("fullName",fullName);
        mv.addObject("books",userBookList);
        return mv;
    }

}

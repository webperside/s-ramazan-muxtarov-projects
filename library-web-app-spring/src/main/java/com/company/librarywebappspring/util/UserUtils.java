package com.company.librarywebappspring.util;

import com.company.librarywebappspring.models.Role;
import com.company.librarywebappspring.models.User;
import com.company.librarywebappspring.security.CustomUserDetail;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserUtils {

    public static User currentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof UserDetails){
            CustomUserDetail userDetail = (CustomUserDetail) principal;
            return userDetail.getUser();
        }

        return null;
    }

    public static boolean isAdmin(){
        User user = currentUser();
        return user != null && user.getRole().getName().equalsIgnoreCase("ADMIN");
    }

    public static Integer getId(){
        User user = currentUser();

        if(user != null) return user.getId();
        return null;
    }

    public static String getFullName(){
        User user = currentUser();

        if(user != null) return user.getName() + " " + user.getSurname();
        return null;
    }
}

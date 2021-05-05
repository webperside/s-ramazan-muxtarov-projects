package com.company.librarywebapp.controller;

import com.company.dao.Context;
import com.company.dao.inter.UserDaoInter;
import com.company.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDaoInter userDaoInter = Context.getUserDao();

        User user = userDaoInter.findByEmailAndPassword(email, password);

        if(user != null){
            req.getSession().setAttribute("loggedInUser", user);
            resp.sendRedirect("books");
        } else {
            resp.sendRedirect("login");
        }

    }
}

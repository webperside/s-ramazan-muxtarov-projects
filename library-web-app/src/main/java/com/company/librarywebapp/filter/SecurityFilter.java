package com.company.librarywebapp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(displayName = "JspFilter", urlPatterns = "*")
public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        Object userLoggedIn = req.getSession().getAttribute("loggedInUser");

        if(!req.getRequestURI().contains("login") && !req.getRequestURI().contains("error")){
            if(userLoggedIn == null){
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else {
            if(userLoggedIn != null){
                req.getRequestDispatcher("books.jsp").forward(req, resp);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}

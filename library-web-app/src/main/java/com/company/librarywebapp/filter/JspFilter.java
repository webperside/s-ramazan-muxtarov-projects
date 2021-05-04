package com.company.librarywebapp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(displayName = "JspFilter", urlPatterns = "*.jsp")
public class JspFilter implements Filter {

//    http://localhost:8080/library/books.jsp
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        resp.sendRedirect("error?msg=Page not found");

//        if(!req.getRequestURI().contains("index")){
//
//        } else{
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
    }

}

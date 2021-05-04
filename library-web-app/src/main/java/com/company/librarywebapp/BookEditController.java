package com.company.librarywebapp;

import com.company.dao.Context;
import com.company.dao.inter.BookDaoInter;
import com.company.models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookEditController", urlPatterns = "/book-edit")
public class BookEditController extends HttpServlet {
//http://localhost:8080/library/book-edit?id=1
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        BookDaoInter bookDaoInter = Context.getBookDao();

        Book book = bookDaoInter.findById(id);

        if(book == null) resp.sendRedirect("books");

        req.setAttribute("book",book);
        req.getRequestDispatcher("book-edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String author = req.getParameter("author");
        Float price = Float.valueOf(req.getParameter("price"));
        Integer stockCount = Integer.valueOf(req.getParameter("stockCount"));

        BookDaoInter bookDaoInter = Context.getBookDao();

        Book book = new Book(id, name, description,author, price, stockCount);

        bookDaoInter.update(book);

        resp.sendRedirect("books");
    }
}

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

@WebServlet(name = "BookDeleteController", urlPatterns = "/book-delete")
public class BookDeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        BookDaoInter bookDaoInter = Context.getBookDao();

        Book book = bookDaoInter.findById(id);

        if(book == null) resp.sendRedirect("books");

        req.setAttribute("book",book);
        req.getRequestDispatcher("book-delete.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDaoInter bookDaoInter = Context.getBookDao();
        Integer id = Integer.valueOf(req.getParameter("id"));
        bookDaoInter.remove(id);
        resp.sendRedirect("books");
    }
}

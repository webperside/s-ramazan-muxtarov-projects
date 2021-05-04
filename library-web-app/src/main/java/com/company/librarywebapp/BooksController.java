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
import java.util.List;

@WebServlet(name = "BooksServlet", urlPatterns = "/books")
public class BooksController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDaoInter bookDao = Context.getBookDao();
        List<Book> books = bookDao.findAll();

        req.setAttribute("books",books);
        req.getRequestDispatcher("books.jsp").forward(req, resp);
//        resp.sendRedirect("books.jsp");
    }
}

package com.company.librarywebapp.util;

import com.company.models.Book;

import javax.servlet.http.HttpServletRequest;

public class BookUtil {

    public static Book createBookFromRequest(HttpServletRequest req){
        String idStr = req.getParameter("id"); // "1" -> 1
        Integer id = null;

        if(idStr != null) id = Integer.valueOf(idStr);

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String author = req.getParameter("author");
        Float price = Float.valueOf(req.getParameter("price"));
        Integer stockCount = Integer.valueOf(req.getParameter("stockCount"));

        return new Book(id, name, description,author, price, stockCount);
    }

}

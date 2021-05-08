package com.company.dao;

import com.company.dao.impl.BookDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.inter.BookDaoInter;
import com.company.dao.inter.UserDaoInter;

public class Context {

    public static UserDaoInter getUserDao(){
        return new UserDaoImpl();
    }

    public static BookDaoInter getBookDao(){
        return new BookDaoImpl();
    }

}

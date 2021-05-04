package com.company.dao.impl;

import com.company.dao.AbstractDao;
import com.company.dao.inter.BookDaoInter;
import com.company.models.Book;
import com.company.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends AbstractDao implements BookDaoInter {

    private Book getBook(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        String author = resultSet.getString("author");
        Float price = resultSet.getFloat("price");
        int stockCount = resultSet.getInt("stock_count");
        return new Book(id, name, description, author, price, stockCount);
    }

    @Override
    public List<Book> findAll() {
        try(Connection c = connect()) {
            Statement statement = c.createStatement();
            String query = "select * from book";

            statement.execute(query);

            ResultSet resultSet = statement.getResultSet();
            List<Book> books = new ArrayList<>();

            while(resultSet.next()){
                books.add(getBook(resultSet));
            }

            return books;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Book findById(Integer id) {
        try(Connection c = connect()) {

            String query = "select * from book where id = ?";

            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);

            ps.execute();

            ResultSet resultSet = ps.getResultSet();
            Book book = null;

            while(resultSet.next()){
                book = getBook(resultSet);
            }
            return book;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Book book) {
        try(Connection c = connect()) {

            String query = "insert into book (name, description, author, price, stock_count) values(?,?,?,?,?)";

            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, book.getName());
            ps.setString(2, book.getDescription());
            ps.setString(3, book.getAuthor());
            ps.setFloat(4, book.getPrice());
            ps.setInt(5, book.getStockCount());

            ps.execute();

            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Book book) {
        try(Connection c = connect()) {

            String query = "update book set name = ?, description = ?, author = ?, price = ?, stock_count = ? where id = ?";

            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, book.getName());
            ps.setString(2, book.getDescription());
            ps.setString(3, book.getAuthor());
            ps.setFloat(4, book.getPrice());
            ps.setInt(5, book.getStockCount());
            ps.setInt(6, book.getId());

            ps.execute();

            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(Integer id) {
        try(Connection c = connect()) {

            String query = "delete from book where id = ?";

            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);

            ps.execute();

            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
}

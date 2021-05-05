package com.company.dao.impl;

import com.company.dao.AbstractDao;
import com.company.dao.inter.UserDaoInter;
import com.company.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    private User getUser(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String email = resultSet.getString("email");
        String pass = resultSet.getString("password");

        return new User(id, name, surname, email, pass);
    }

    @Override
    public List<User> findAll() {
        try(Connection c = connect()) {
            Statement statement = c.createStatement();
            String query = "select * from user";

            statement.execute(query);

            ResultSet resultSet = statement.getResultSet();
            List<User> users = new ArrayList<>();

            while(resultSet.next()){
                users.add(getUser(resultSet));
            }

            return users;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        try(Connection c = connect()) {
//            Statement statement = c.createStatement();
//            String query = "select * from user where id = " + id;

//            statement.execute(query);

            String query = "select * from user where email = ? and password = ?";

            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            ps.execute();

            ResultSet resultSet = ps.getResultSet();
            User user = null;

            while(resultSet.next()){
                user = getUser(resultSet);
            }
            return user;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public User findById(Integer id) {
        try(Connection c = connect()) {
//            Statement statement = c.createStatement();
//            String query = "select * from user where id = " + id;

//            statement.execute(query);

            String query = "select * from user where id = ?";

            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);

            ps.execute();

            ResultSet resultSet = ps.getResultSet();
            User user = null;

            while(resultSet.next()){
                user = getUser(resultSet);
            }
            return user;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(User user) {
        try(Connection c = connect()) {

            String query = "insert into user (name, surname, email, password) values(?,?,?,?)";

            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());

            ps.execute();

            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        try(Connection c = connect()) {

            String query = "update user set name = ?, surname = ?, email = ?, password = ? where id = ?";

            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getId());

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

            String query = "delete from user where id = ?";

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

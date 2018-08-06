package com.aptech.webent.dao;

import com.aptech.webent.helper.MSSQLConnection;
import com.aptech.webent.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private MSSQLConnection mssqlConnection;

    public UserDAO() {
        mssqlConnection = new MSSQLConnection();
    }

    public boolean checkLogin (String username, String password){

        boolean isValid= false;
        String sql = "Select * From users where username = '"+username+"' and password = '"+ password+"'";
        try (ResultSet resultSet = mssqlConnection.query(sql)) {
                if(resultSet.next()){
                    System.out.println("ok");
                    isValid=true;
                }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isValid;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String sql ="SELECT * FROM USERS";
        try (ResultSet rs = mssqlConnection.query(sql)) {
            while (rs.next()){
                users.add(new User(rs.getInt("id"),rs.getString("username"),rs.getString("password")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        boolean b = userDAO.checkLogin("admin", "admin");
        System.out.println(b);

    }


}

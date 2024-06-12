package org.poorman.blogs.dao.impl;

import org.poorman.blogs.dao.UserDAO;
import org.poorman.blogs.entity.Post;
import org.poorman.blogs.entity.User;
import org.poorman.blogs.util.DruidPool;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class UserDAOImpl implements UserDAO {
//    //Set mysql connection information
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/blogs";
//    private static final String USER = "root";
//    private static final String PASS = "123";

    @Override
    public User getUserByUsername(String username) throws ClassNotFoundException {
        User user = new User();
//        Class.forName("com.mysql.cj.jdbc.Driver");

        //Connect to the database
        try (Connection conn = DruidPool.getDataSource().getConnection();

             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username=?")) {
            pstmt.setString(1, username);

            //execute sql
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    //Get parameters from the table
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setId(rs.getInt("id"));
                    user.setRole(rs.getString("role"));
                    user.setSalt(rs.getString("salt"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // 异常处理逻辑
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> getUserList() {
        List<User> users = new ArrayList<>();

        try (Connection conn = DruidPool.getDataSource().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String role = rs.getString("role");

                users.add(new User(id, role, username));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public Boolean register(String username, String password) {
        return null;
    }

    @Override
    public Boolean add(String username, String password, String role, String salt) {

        boolean IsAdded = false;

        try (Connection conn = DruidPool.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (username, password, role, salt) VALUES (?, ?, ?,?)")) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            pstmt.setString(4, salt);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                IsAdded = true;
            }

        } catch (SQLException e) {
            // 记录日志或抛出自定义异常
            e.printStackTrace();
        }

        return IsAdded;
    }
}

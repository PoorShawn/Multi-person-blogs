package org.poorman.blogs.dao.impl;

import org.poorman.blogs.dao.UserDAO;
import org.poorman.blogs.entity.User;

import java.sql.*;


public class UserDAOImpl implements UserDAO {
    //Set mysql connection information
    private static final String DB_URL = "jdbc:mysql://localhost:3306/blogs";
    private static final String USER = "root";
    private static final String PASS = "123";

    @Override
    public User getUserByUsername(String username) throws ClassNotFoundException {
        User user = new User();
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Connect to the database
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

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
        }
        return user;
    }
}

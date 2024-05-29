package org.poorman.blogs.dao.impl;

import org.poorman.blogs.dao.UserDAO;
import org.poorman.blogs.entity.User;

import java.sql.*;


public class UserDAOImpl implements UserDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/blogs";
    private static final String USER = "root";
    private static final String PASS = "123";

    @Override
    public User getUserByUsername(String username) throws ClassNotFoundException, SQLException {
        User user = new User();
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username=?")) {

            pstmt.setString(1, username);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setId(rs.getString("id"));
                    user.setRole(rs.getString("role"));
                   // 实际应用中不应直接存储明文密码，此处仅为示例
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // 异常处理逻辑
        }
        return user;
    }
}

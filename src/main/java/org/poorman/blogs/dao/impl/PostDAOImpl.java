package org.poorman.blogs.dao.impl;

import org.poorman.blogs.dao.PostDAO;
import org.poorman.blogs.util.DruidPool;

import java.sql.*;

public class PostDAOImpl implements PostDAO {
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/blogs";
//    private static final String USER = "root";
//    private static final String PASS = "123";

    @Override
    public boolean uploadPost(String title, String content, int author_id) throws ClassNotFoundException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
        boolean isUploaded = false;

        try (Connection conn = DruidPool.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO posts (title, content, author_id) VALUES (?, ?, ?)")) {

            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setInt(3, author_id);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                isUploaded = true;
            }

        } catch (SQLException e) {
            // 记录日志或抛出自定义异常
            e.printStackTrace();
        }

        return isUploaded;
    }
}

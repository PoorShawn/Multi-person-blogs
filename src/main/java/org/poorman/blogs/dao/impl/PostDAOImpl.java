package org.poorman.blogs.dao.impl;

import org.poorman.blogs.dao.PostDAO;
import org.poorman.blogs.entity.Post;
import org.poorman.blogs.util.DruidPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Post> displayPost() {
        List<Post> posts = new ArrayList<>();

        try (Connection conn = DruidPool.getDataSource().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM posts ORDER BY id DESC");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String text = rs.getString("content");
                int author_id = rs.getInt("author_id");
                String description = rs.getString("description");
                posts.add(new Post(id, title, text, author_id, description));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return posts;
    }

    @Override
    public Post getPostById(int id) {
        Post post = new Post();

        try (Connection conn = DruidPool.getDataSource().getConnection();

             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM posts WHERE id=?")) {
            pstmt.setInt(1, id);

            //execute sql
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    //Get parameters from the table
                    post.setId(rs.getInt("id"));
                    post.setTitle(rs.getString("title"));
                    post.setAuthor_id(rs.getInt("author_id"));
                    post.setText(rs.getString("content"));
                    post.setDescription(rs.getString("description"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // 异常处理逻辑
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return post;
    }

    @Override
    public boolean deletePostById(int id) {
        boolean isDeleted = false;

        try (Connection conn = DruidPool.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM posts WHERE id = ?")) {

            pstmt.setInt(1, id);  // 设置要删除的用户ID

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                isDeleted = true;
            }

        } catch (SQLException e) {
            // 记录日志或抛出自定义异常，而不是简单打印堆栈跟踪
            e.printStackTrace();
        }

        return isDeleted;
    }
}

package org.poorman.blogs.dao.impl;

import org.poorman.blogs.dao.CommentDAO;
import org.poorman.blogs.entity.Comment;
import org.poorman.blogs.entity.Post;
import org.poorman.blogs.util.DruidPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO {
    @Override
    public boolean upload(String content, int postId, int userId) throws ClassNotFoundException {
        return false;
    }

    @Override
    public List<Comment> getCommentListByPostId(int postId) {
        List<Comment> commentList = new ArrayList<>();

        try (Connection conn = DruidPool.getDataSource().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM comments WHERE posts_id = ? ORDER BY create_at DESC");
            pstmt.setInt(1, postId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                LocalDateTime create_at = rs.getTimestamp("create_at").toLocalDateTime();
                int posts_id = rs.getInt("posts_id");
                int user_id = rs.getInt("user_id");
                commentList.add(new Comment(id, content, create_at, user_id, posts_id));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return commentList;
    }
}

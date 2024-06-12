package org.poorman.blogs.service;

import org.poorman.blogs.entity.Comment;

import java.sql.SQLException;
import java.util.List;

public interface CommentService {
    boolean upload(String content, int postId, int userId) throws ClassNotFoundException, SQLException;
    List<Comment> getCommentList(int postId);
}

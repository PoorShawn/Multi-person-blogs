package org.poorman.blogs.dao;

import org.poorman.blogs.entity.Comment;

import java.util.List;

public interface CommentDAO {
    boolean upload(String content, int postId, int userId) throws ClassNotFoundException;

    List<Comment> getCommentListByPostId(int postId);
}

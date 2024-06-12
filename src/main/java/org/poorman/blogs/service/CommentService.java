package org.poorman.blogs.service;

import org.poorman.blogs.entity.Comment;

import java.util.List;

public interface CommentService {
    boolean upload(String content, int postId, int userId) throws ClassNotFoundException;
    List<Comment> getCommentList(int postId);
}

package org.poorman.blogs.service.impl;

import org.poorman.blogs.dao.CommentDAO;
import org.poorman.blogs.dao.impl.CommentDAOImpl;
import org.poorman.blogs.entity.Comment;
import org.poorman.blogs.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentDAO commentDAO = new CommentDAOImpl();

    @Override
    public boolean upload(String content, int postId, int userId) throws ClassNotFoundException {
        return false;
    }

    @Override
    public List<Comment> getCommentList(int postId) {
        if (postId == 0) {
            return null;
        }

        return commentDAO.getCommentListByPostId(postId);
    }
}

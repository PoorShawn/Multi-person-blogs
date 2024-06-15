package org.poorman.blogs.service.impl;

import org.poorman.blogs.dao.CommentDAO;
import org.poorman.blogs.dao.impl.CommentDAOImpl;
import org.poorman.blogs.entity.Comment;
import org.poorman.blogs.service.CommentService;

import java.sql.SQLException;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentDAO commentDAO = new CommentDAOImpl();

    @Override
    public boolean upload(String content, int postId, int userId) throws ClassNotFoundException, SQLException {
        if (content != null && postId != 0 && userId != 0) {
            System.out.println("in service has upload");
            return commentDAO.upload(content, postId, userId);
        }
        System.out.println("in service has not upload");
        return false;
    }

    @Override
    public List<Comment> getCommentList(int postId) {
        if (postId == 0) {
            return null;
        }

        return commentDAO.getCommentListByPostId(postId);
    }

    @Override
    public boolean delete(int commentId) {
        if (commentId == 0) {
            return false;
        }
        return commentDAO.deleteCommentById(commentId);
    }
}

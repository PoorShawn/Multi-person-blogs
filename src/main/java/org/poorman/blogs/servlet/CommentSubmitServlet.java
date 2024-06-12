package org.poorman.blogs.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.poorman.blogs.entity.Post;
import org.poorman.blogs.entity.User;
import org.poorman.blogs.service.CommentService;
import org.poorman.blogs.service.impl.CommentServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "commentSubmitServlet", value = "/commentSubmit-servlet")
public class CommentSubmitServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Get parameters
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        Post post = (Post) session.getAttribute("currentPost");
        String content = request.getParameter("content");

        System.out.println("user:"+user);
        System.out.println("post:"+post);
        System.out.println("content:"+content);

        //Send parameters to service
        CommentService commentService = new CommentServiceImpl();
        boolean IsUploaded;
        try {
            IsUploaded = commentService.upload(content, post.getId(), user.getId());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Return errors if error happens
        if (!IsUploaded) {
            session.setAttribute("message", "评论失败，请重试！");
        }

        response.sendRedirect("postDisplay-servlet?postId=" + post.getId());

    }
}

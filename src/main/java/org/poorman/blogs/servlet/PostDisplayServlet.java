package org.poorman.blogs.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.poorman.blogs.entity.Comment;
import org.poorman.blogs.entity.Post;
import org.poorman.blogs.service.CommentService;
import org.poorman.blogs.service.PostService;
import org.poorman.blogs.service.impl.CommentServiceImpl;
import org.poorman.blogs.service.impl.PostServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "PostDisplayServlet", value = "/postDisplay-servlet")
public class PostDisplayServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //System.out.println("post_id"+id);

        //Call PostServiceImpl() to get post
        PostService postService = new PostServiceImpl();
        Post post = postService.getPost(id);
        request.setAttribute("post",post);

        //Call CommentServiceImpl() to upload comment
        CommentService commentService = new CommentServiceImpl();
        List<Comment> commentList = commentService.getCommentList(id);
        request.setAttribute("commentList",commentList);

        request.getRequestDispatcher("/postDisplay.jsp").forward(request, response);
    }
}

package org.poorman.blogs.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.poorman.blogs.entity.Post;
import org.poorman.blogs.service.CommentService;
import org.poorman.blogs.service.PostService;
import org.poorman.blogs.service.impl.CommentServiceImpl;
import org.poorman.blogs.service.impl.PostServiceImpl;

import java.io.IOException;

@WebServlet(name = "postUpdateServlet", value = "/postUpdate-servlet")
public class PostUpdateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int postId = Integer.parseInt(request.getParameter("postId"));
        //int postId = Integer.parseInt(request.getParameter("postId"));

        PostService postService = new PostServiceImpl();
        boolean IsUpdated = postService.delete(postId);

        HttpSession session = request.getSession();
        if (IsUpdated) {
            session.setAttribute("message", "Post deleted successfully");
//            request.getRequestDispatcher("/postDisplay-servlet").forward(request, response);
        } else {
            session.setAttribute("message", "Post delete fail");
//            request.getRequestDispatcher("/postDisplay-servlet").forward(request, response);
        }


        request.getRequestDispatcher("/postIndex-servlet").forward(request, response);
    }
}

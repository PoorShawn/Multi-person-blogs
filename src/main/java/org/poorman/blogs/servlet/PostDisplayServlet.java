package org.poorman.blogs.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.poorman.blogs.entity.Post;
import org.poorman.blogs.service.PostService;
import org.poorman.blogs.service.impl.PostServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "PostDisplayServlet", value = "/postDisplay-servlet")
public class PostDisplayServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //System.out.println("post_id"+id);

        //Call PostServiceImpl() to upload post
        PostService postService = new PostServiceImpl();
        Post post = postService.getPost(id);

        request.setAttribute("post",post);
        request.getRequestDispatcher("/postDisplay.jsp").forward(request, response);
    }
}

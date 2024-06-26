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

@WebServlet(name = "PostIndexServlet", value = "/postIndex-servlet")
public class PostIndexServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Call PostServiceImpl() to upload post
        PostService postService = new PostServiceImpl();

        List<Post> posts = postService.getPostList();
        request.setAttribute("posts",posts);
        request.getRequestDispatcher("/postIndex.jsp").forward(request, response);
    }
}

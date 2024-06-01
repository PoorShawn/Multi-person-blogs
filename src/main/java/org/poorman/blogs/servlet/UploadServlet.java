package org.poorman.blogs.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.poorman.blogs.entity.User;
import org.poorman.blogs.service.PostService;
import org.poorman.blogs.service.UserService;
import org.poorman.blogs.service.impl.PostServiceImpl;
import org.poorman.blogs.service.impl.UserServiceImpl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "uploadServlet", value = "/upload-servlet")
public class UploadServlet extends HttpServlet {
    private String message;

    public void init() {
        message = null;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Get parameters from jsp
        String title = request.getParameter("title");
        String text = request.getParameter("contentText");

        //Get user information from session
        HttpSession session = request.getSession(false); // false表示如果没有Session则返回null，避免创建新的Session
        User currentUser = (User) session.getAttribute("currentUser");

        //Call PostServiceImpl() to upload post
        PostService postService = new PostServiceImpl();
        boolean IsUpLoaded = false;
        try {
            IsUpLoaded = postService.upload(title, text, currentUser);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (!IsUpLoaded) {
            message = "上传失败，请重试";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/postUpload.jsp").forward(request, response);
        }

        //Call next jsp directly
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    public void destroy() {
    }
}

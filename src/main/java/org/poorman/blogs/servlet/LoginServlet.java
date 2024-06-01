package org.poorman.blogs.servlet;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Objects;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.poorman.blogs.entity.User;
import org.poorman.blogs.service.UserService;
import org.poorman.blogs.service.impl.UserServiceImpl;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {
        message = null;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Get parameters from jsp
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //Call UserServiceImpl() to login in
        UserService userService = new UserServiceImpl();
        User user;
        try {
            try {
                user = userService.login(username, password);
            } catch (ClassNotFoundException | NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Return errors based on the call
        if (user == null) {
            message ="用户名或密码错误";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        HttpSession session = request.getSession();
        session.setAttribute("currentUser", user);

        //Call next jsp directly
        request.getRequestDispatcher("/index.jsp").forward(request, response);

//        if (Objects.equals(username, "") || Objects.equals(password, "")) {
//            message ="用户名或密码为空";
//            request.setAttribute("message", message);
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
//        }
//        if (username != null && password != null) {
//            HttpSession session = request.getSession();
//            session.setAttribute("username", username);
//            session.setAttribute("password", password);
//            response.sendRedirect("/");
//        }
    }

    public void destroy() {
    }
}

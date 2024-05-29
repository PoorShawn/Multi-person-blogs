package org.poorman.blogs.servlet;

import java.io.*;
import java.sql.SQLException;
import java.util.Objects;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.poorman.blogs.service.UserService;
import org.poorman.blogs.service.impl.UserServiceImpl;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {
        message = null;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService = new UserServiceImpl();
        try {
            message = userService.login(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("/login.jsp").forward(request,response);
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

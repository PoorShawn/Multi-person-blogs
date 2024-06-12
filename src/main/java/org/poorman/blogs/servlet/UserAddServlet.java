package org.poorman.blogs.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.poorman.blogs.service.UserService;
import org.poorman.blogs.service.impl.UserServiceImpl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "userAddServlet", value = "/userAdd-servlet")
public class UserAddServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        Boolean IsAdded;
        HttpSession session = request.getSession();

        UserService userService = new UserServiceImpl();
        try {
            IsAdded = userService.add(username, password, role);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        if (!IsAdded) {
            session.setAttribute("message", "用户新增失败，请重试！");
            //request.getRequestDispatcher("/UserManager.jsp").forward(request, response);
        }
        else {
            session.setAttribute("message", "用户新增成功！");
            //request.getRequestDispatcher("/UserManager.jsp").forward(request, response);
        }

        response.sendRedirect("userManage-servlet");
    }
}

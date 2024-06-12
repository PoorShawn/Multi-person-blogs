package org.poorman.blogs.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.poorman.blogs.entity.User;
import org.poorman.blogs.service.UserService;
import org.poorman.blogs.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet(name = "userRoleAlterServlet", value = "/userRoleAlter-servlet")
public class UserRoleAlterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Check if user is admin
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        if (!currentUser.getRole().equals("ADMIN")) {
            session.setAttribute("message", "Invalid Deed!");
            request.getRequestDispatcher("UserManage.jsp").forward(request, response);
        }

        String action = request.getParameter("action");
        int userId = Integer.parseInt(request.getParameter("userId"));

        Boolean IsUpDated = false;
//        HttpSession session = request.getSession();
        UserService userService = new UserServiceImpl();

        if (action.equals("promote")) {
            IsUpDated = userService.promote(userId);
        } else if (action.equals("demote")) {
            IsUpDated = userService.demote(userId);
        } else if (action.equals("delete")) {
            IsUpDated = userService.delete(userId);
        }

        if (IsUpDated) {
            session.setAttribute("message", "User Updated");
        } else {
            session.setAttribute("message", "User Update Failed");
        }

        response.sendRedirect("userManage-servlet");
    }
}

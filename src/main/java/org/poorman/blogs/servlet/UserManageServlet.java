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
import java.util.List;

@WebServlet(name = "userManageServlet", value = "/userManage-servlet")
public class UserManageServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.getUserList();

        //HttpSession session = request.getSession();
        //session.setAttribute("userList", userList);

        request.setAttribute("userList", userList);
        request.getRequestDispatcher("UserManage.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                System.out.println("addddddd");
                request.getRequestDispatcher("/UserManage.jsp");
                break;
            case "promote":
                System.out.println("promot");
            case "demote":
                System.out.println("demot");
            case "delete":
                System.out.println("delete");
                modifyUser(request, response, action);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
        }
    }

//    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String newUsername = request.getParameter("newUsername");
//        String password = request.getParameter("password");
//        String role = request.getParameter("role");
//
//
//        Boolean IsAdded = false;
//        HttpSession session = request.getSession();
//        IsAdded =  userService.add(newUsername, password ,role); // 实现创建用户的逻辑
//        if (!IsAdded) {
//            session.setAttribute("message", "用户新增失败，请重试！");
//            //request.getRequestDispatcher("/UserManager.jsp").forward(request, response);
//            response.sendRedirect("/userManage-servlet");
//        }
//
//        response.sendRedirect(request.getContextPath() + "/userManage-servlet");
//    }

    private void modifyUser(HttpServletRequest request, HttpServletResponse response, String action) throws IOException, ServletException, ServletException {
        int userId = Integer.parseInt(request.getParameter("id"));
        switch (action) {
            case "promote":
                userService.promote(userId);
                break;
            case "demote":
                userService.demote(userId);
                break;
            case "delete":
                userService.delete(userId);
                break;
        }
        // 刷新用户列表
        List<User> userList = userService.getUserList();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }
}

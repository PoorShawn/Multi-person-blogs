package org.poorman.blogs.service.impl;

import org.poorman.blogs.dao.UserDAO;
import org.poorman.blogs.dao.impl.UserDAOImpl;
import org.poorman.blogs.entity.User;
import org.poorman.blogs.service.UserService;

import java.sql.SQLException;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    String message = "";

    @Override
    public String login(String username, String password) throws SQLException, ClassNotFoundException {
        if (Objects.equals(username, "") || Objects.equals(password, "")) {
            message ="用户名或密码为空";
            return message;
        }

        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUserByUsername(username);
        System.out.println(user);

        if (!Objects.equals(user.getPassword(), password)) {
            message ="用户名或密码错误";
            return message;
        }

        message = "登录成功";
        return message;
    }

    @Override
    public String register(String username, String password) {
        return "";
    }
}

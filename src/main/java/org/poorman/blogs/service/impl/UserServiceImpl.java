package org.poorman.blogs.service.impl;

import org.poorman.blogs.dao.UserDAO;
import org.poorman.blogs.dao.impl.UserDAOImpl;
import org.poorman.blogs.entity.User;
import org.poorman.blogs.service.UserService;
import org.poorman.blogs.util.PasswordHashing;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    String message = "";

    @Override
    public String login(String username, String password) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        if (Objects.equals(username, "") || Objects.equals(password, "")) {
            message ="用户名或密码为空";
            return message;
        }

        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUserByUsername(username);

        if (!PasswordHashing.verifyPassword(password, user.getSalt(), user.getPassword())) {
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

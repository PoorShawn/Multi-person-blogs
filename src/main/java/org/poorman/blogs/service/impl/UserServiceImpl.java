package org.poorman.blogs.service.impl;

import org.poorman.blogs.dao.UserDAO;
import org.poorman.blogs.dao.impl.UserDAOImpl;
import org.poorman.blogs.entity.User;
import org.poorman.blogs.service.UserService;
import org.poorman.blogs.util.PasswordHashing;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    String message = "";
    UserDAO userDAO = new UserDAOImpl();

    @Override
    public User login(String username, String password) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        if (Objects.equals(username, "") || Objects.equals(password, "")) {
            //message ="用户名或密码为空";
            return null;
        }

        User user = userDAO.getUserByUsername(username);

        if (!PasswordHashing.verifyPassword(password, user.getSalt(), user.getPassword())) {
            //message ="用户名或密码错误";
            return null;
        }

        message = "登录成功";
        return user;
    }

    @Override
    public Boolean register(String username, String password) {
        return false;
    }

    @Override
    public Boolean add(String username, String password, String role) {
        return null;
    }

    @Override
    public Boolean promote(int userId) {
        return null;
    }

    @Override
    public Boolean demote(int userId) {
        return null;
    }

    @Override
    public Boolean delete(int userId) {
        return null;
    }

    @Override
    public List<User> getUserList() {
        return userDAO.getUserList();
    }
}

package org.poorman.blogs.service;

import org.poorman.blogs.entity.User;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public interface UserService {
    User login(String username, String password) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException;

    Boolean register(String username, String password);

    Boolean add(String username, String password, String role);

    Boolean promote(int userId);

    Boolean demote(int userId);

    Boolean delete(int userId);

    List<User> getUserList();

}

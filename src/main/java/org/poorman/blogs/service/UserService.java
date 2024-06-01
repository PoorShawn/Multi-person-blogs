package org.poorman.blogs.service;

import org.poorman.blogs.entity.User;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public interface UserService {
    User login(String username, String password) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException;

    String register(String username, String password);
}

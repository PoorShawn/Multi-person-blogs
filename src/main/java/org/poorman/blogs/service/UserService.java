package org.poorman.blogs.service;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public interface UserService {
    String login(String username, String password) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException;

    String register(String username, String password);
}

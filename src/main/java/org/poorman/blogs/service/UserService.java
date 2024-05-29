package org.poorman.blogs.service;

import java.sql.SQLException;

public interface UserService {
    String login(String username, String password) throws SQLException, ClassNotFoundException;

    String register(String username, String password);
}

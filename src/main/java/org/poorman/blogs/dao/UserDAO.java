package org.poorman.blogs.dao;

import org.poorman.blogs.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    User getUserByUsername(String username) throws ClassNotFoundException, SQLException;

    List<User> getUserList();

    Boolean register(String username, String password);

    Boolean add(String username, String password, String role, String salt);
}

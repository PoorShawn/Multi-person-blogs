package org.poorman.blogs.dao;

import org.poorman.blogs.entity.User;

import java.sql.SQLException;

public interface UserDAO {
    User getUserByUsername(String username) throws ClassNotFoundException, SQLException;
}

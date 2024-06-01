package org.poorman.blogs.service;

import org.poorman.blogs.entity.User;

public interface PostService {
    boolean upload(String title, String text, User user) throws ClassNotFoundException;
}

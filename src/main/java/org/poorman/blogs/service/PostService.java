package org.poorman.blogs.service;

import org.poorman.blogs.entity.Post;
import org.poorman.blogs.entity.User;

import java.util.List;

public interface PostService {
    boolean upload(String title, String text, User user) throws ClassNotFoundException;
    List<Post> getPostList();
    Post getPost(int id);
    boolean delete(int id);
}

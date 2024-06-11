package org.poorman.blogs.dao;

import org.poorman.blogs.entity.Post;

import java.util.List;

public interface PostDAO {
    boolean uploadPost(String title, String content, int author_id) throws ClassNotFoundException;
    List<Post> displayPost();
    Post getPostById(int id);
}

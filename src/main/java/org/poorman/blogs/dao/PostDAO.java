package org.poorman.blogs.dao;

public interface PostDAO {
    boolean uploadPost(String title, String content, int author_id) throws ClassNotFoundException;
}

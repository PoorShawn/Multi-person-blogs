package org.poorman.blogs.service.impl;

import jakarta.servlet.http.HttpSession;
import org.poorman.blogs.dao.PostDAO;
import org.poorman.blogs.dao.impl.PostDAOImpl;
import org.poorman.blogs.entity.Post;
import org.poorman.blogs.entity.User;
import org.poorman.blogs.service.PostService;

import java.nio.file.FileStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostServiceImpl implements PostService {
    PostDAO postDAO = new PostDAOImpl();
    @Override
    public boolean upload(String title, String text, User user) throws ClassNotFoundException {
        //Check out parameters
        if (Objects.equals(title, "") || Objects.equals(text, "") || user == null) {
            return false;
        }

        //Call PostDAOImpl() to upload post
        return postDAO.uploadPost(title, text, user.getId());
    }

    @Override
    public List<Post> getPostList() {
        //Call PostDAOImpl() to upload post
        List<Post> posts = postDAO.displayPost();

        List<Post> finalPosts = new ArrayList<>();
        for (Post post : posts) {
            // check if the title or text is null
            if ( post.getTitle() == null || post.getText() == null || Objects.equals(post.getTitle(), "") || Objects.equals(post.getText(), "")) {
                continue;
            }

            finalPosts.add(post);
        }
        return finalPosts;
    }

    @Override
    public Post getPost(int id) {
        return postDAO.getPostById(id);
    }

    @Override
    public boolean delete(int id) {
        if (id == 0) {
            return false;
        }

        return postDAO.deletePostById(id);
    }
}

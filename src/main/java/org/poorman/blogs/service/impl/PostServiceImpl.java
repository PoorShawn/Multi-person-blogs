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
    @Override
    public boolean upload(String title, String text, User user) throws ClassNotFoundException {
        //Check out parameters
        if (Objects.equals(title, "") || Objects.equals(text, "") || user == null) {
            return false;
        }

        //Call PostDAOImpl() to upload post
        PostDAO postDAO = new PostDAOImpl();
        return postDAO.uploadPost(title, text, user.getId());
    }

    @Override
    public List<Post> getPosts() {
        //Call PostDAOImpl() to upload post
        PostDAO postDAO = new PostDAOImpl();
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
}

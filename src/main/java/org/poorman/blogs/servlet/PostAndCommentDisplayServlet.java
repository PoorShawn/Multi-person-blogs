package org.poorman.blogs.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.poorman.blogs.entity.Comment;
import org.poorman.blogs.entity.Post;
import org.poorman.blogs.service.CommentService;
import org.poorman.blogs.service.PostService;
import org.poorman.blogs.service.impl.CommentServiceImpl;
import org.poorman.blogs.service.impl.PostServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "PostDisplayServlet", value = "/postDisplay-servlet")
public class PostAndCommentDisplayServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        HttpSession session = request.getSession();
        if (request.getParameter("postId") != null) {
            id = Integer.parseInt(request.getParameter("postId"));
        } else {
            Post post = (Post) session.getAttribute("currentPost");
            id = post.getId();
        }
//        int id = Integer.parseInt(request.getParameter("postId"));
        //System.out.println("post_id"+id);

        //Call PostServiceImpl() to get post
        PostService postService = new PostServiceImpl();
        Post post = postService.getPost(id);
        request.setAttribute("post",post);

        //Call CommentServiceImpl() to display comment
        CommentService commentService = new CommentServiceImpl();
        List<Comment> commentList = commentService.getCommentList(id);
        request.setAttribute("commentList",commentList);

//        HttpSession session = request.getSession();
        session.setAttribute("currentPost",post);

        request.getRequestDispatcher("/postDisplay.jsp").forward(request, response);
    }
}

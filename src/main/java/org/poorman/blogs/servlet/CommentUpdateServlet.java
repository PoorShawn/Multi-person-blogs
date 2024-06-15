package org.poorman.blogs.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.poorman.blogs.entity.Post;
import org.poorman.blogs.service.CommentService;
import org.poorman.blogs.service.impl.CommentServiceImpl;

import java.io.IOException;

@WebServlet(name = "commentUpdateServlet", value = "/commentUpdate-servlet")
public class CommentUpdateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int commentId = Integer.parseInt(request.getParameter("commentId"));
        //int postId = Integer.parseInt(request.getParameter("postId"));

        CommentService commentService = new CommentServiceImpl();
        boolean IsUpdated = commentService.delete(commentId);

        HttpSession session = request.getSession();
        if (IsUpdated) {
            session.setAttribute("message", "Comment deleted successfully");
//            request.getRequestDispatcher("/postDisplay-servlet").forward(request, response);
        } else {
            session.setAttribute("message", "Comment delete fail");
//            request.getRequestDispatcher("/postDisplay-servlet").forward(request, response);
        }

        Post post = (Post) session.getAttribute("currentPost");

        // 修改转发的URL为PostAndCommentDisplayServlet的映射路径
        int postId = post.getId();// 确保你从请求中获取postId
        if (postId != 0) {
            request.setAttribute("postId", postId); // 设置postId为转发请求的属性，以便PostAndCommentDisplayServlet使用
            request.getRequestDispatcher("/postDisplay-servlet").forward(request, response);
        } else {
            // 如果无法获取postId，提供一个错误处理或重定向到一个适当的页面
            response.sendRedirect(request.getContextPath() + "/index.jsp"); // 假设有一个错误页面
        }

        //response.sendRedirect("postDisplay-servlet");
        //request.getRequestDispatcher("/postDisplay-servlet").forward(request, response);
        //request.getRequestDispatcher("/postDisplay-servlet").forward(request, response);
    }
}

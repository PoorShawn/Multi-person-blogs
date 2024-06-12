<%@ page import="org.poorman.blogs.entity.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="org.poorman.blogs.entity.Comment" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: poorshawn
  Date: 2024/6/6
  Time: 上午8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Posts</title>
</head>
<body>
<h2>帖子及评论列表</h2>
<table border="1">
    <%
        Post post = (Post) request.getAttribute("post");
        if (post != null) {
    %>
    <!-- 帖子的第一行：作者ID和标题 -->
    <tr>
        <td>作者ID:<%=post.getAuthor_id()%></td>
        <td><strong>标题:<%=post.getTitle()%></strong></td>
    </tr>
    <!-- 帖子的第二行：内容 -->
    <tr>
        <td colspan="2"><%=post.getText()%></td>
    </tr>

<%--    <tr><td colspan="2" height="10"></td></tr>--%>

    <%
    } else {
    %>
    <tr><td colspan="2">暂无帖子!</td></tr>
    <% } %>
</table>

<%
    List<Comment> comments = (List<Comment>) request.getAttribute("commentList"); // 假设从请求中获取到了评论列表
%>

<!-- 在帖子内容展示之后，添加评论展示区域 -->
<%
    if (comments != null && !comments.isEmpty()) {
%>
<h3>评论列表</h3>
<table border="1">
    <thead>
    <tr>
        <th>评论时间</th>
        <th>评论用户ID</th>
        <th>评论内容</th>
    </tr>
    </thead>
    <tbody>
    <% for (Comment comment : comments) { %>
    <tr>
        <th><%=comment.getCreateAt()%></th>
        <td><%=comment.getUserId()%></td>
        <td><%=comment.getContent()%></td>
    </tr>
    <% } %>
    </tbody>
</table>
<%
} else {
%>
<tr><td colspan="2">暂无评论</td></tr>
<%
    }
%>

<!-- 新增评论表单部分 -->
<%
    // 检查session中是否有用户ID，来判断用户是否登录
    //HttpSession session = request.getSession(false);
    boolean isLoggedIn = session.getAttribute("currentUser") != null;
%>
<% if (isLoggedIn) { %>
<h3>添加评论</h3>
<form action="${pageContext.request.contextPath}/commentSubmit-servlet" method="post">
    <%--    <input type="hidden" name="postId" value="${currentPostId}">--%>
    <label for="commentContent">评论内容:</label><br>
    <textarea id="commentContent" name="content" rows="4" cols="50" required></textarea><br>
    <input type="submit" value="提交评论">
</form>
<% } %>

<%
    PrintWriter printWriter = response.getWriter();
    if(session.getAttribute("message")!= null){
        printWriter.write((String)session.getAttribute("message"));
        printWriter.flush();
        session.removeAttribute("message");
    }
%>
</body>
</html>

<%@ page import="org.poorman.blogs.entity.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="org.poorman.blogs.entity.User" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: poorshawn
  Date: 2024/6/11
  Time: 上午8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>帖子列表</h2>
<table border="1">
    <%
        User currentUser = (User) session.getAttribute("currentUser");
        List<Post> posts = (List<Post>) request.getAttribute("posts");
        if(posts != null && !posts.isEmpty()){
            for(Post post : posts){
    %>
    <!-- 帖子的第一行：作者ID和标题 -->
    <tr>
        <td>
            作者ID:<%=post.getAuthor_id()%>&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/postDisplay-servlet?postId=<%=post.getId()%>" style="text-decoration:none;">
                <strong>标题: <%=post.getTitle()%></strong>
            </a>
        </td>
    </tr>
    <!-- 帖子的第二行：description 及 删除链接 -->
    <tr>
        <td colspan="2">
            description:<%=post.getDescription()%>&nbsp;&nbsp;&nbsp;
            <% if ("ADMIN".equals(currentUser.getRole()) || post.getId()== currentUser.getId()) { %>
            <a href="${pageContext.request.contextPath}/postUpdate-servlet?postId=<%=post.getId()%>">删除</a>
            <% } %>
        </td>
    </tr>

    <%
        }
    } else {
    %>
    <tr><td colspan="2">暂无帖子!</td></tr>
    <% } %>

    <%
        PrintWriter printWriter = response.getWriter();
        if(session.getAttribute("message")!= null){
            printWriter.write((String)session.getAttribute("message"));
            printWriter.flush();
            session.removeAttribute("message");
        }
    %>
</table>
</body>
</body>
</html>


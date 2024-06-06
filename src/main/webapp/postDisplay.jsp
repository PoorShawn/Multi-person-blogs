<%@ page import="org.poorman.blogs.entity.Post" %>
<%@ page import="java.util.List" %><%--
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
<h2>帖子列表</h2>
<table border="1">
    <tr>
        <th>author_id</th>
        <th>标题</th>
        <th>内容</th>
    </tr>
    <%
        List<Post> posts = (List<Post>) request.getAttribute("posts");
        if(posts != null && !posts.isEmpty()){
            for(Post post : posts){
    %>
    <tr>
        <td><%=post.getId()%></td>
        <td><%=post.getTitle()%></td>
        <td><%=post.getText()%></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr><td colspan="3">暂无帖子!</td></tr>
    <% } %>
</table>
</body>
</html>

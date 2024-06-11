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
<%--    <!-- 假设Post类中包含一个comments列表属性 -->--%>
<%--    <%--%>
<%--        if(post.getComments() != null && !post.getComments().isEmpty()){--%>
<%--            for(String comment : post.getComments()){--%>
<%--    %>--%>
<%--    <!-- 帖子的第三行开始，每次循环为一条评论 -->--%>
<%--    <tr>--%>
<%--        <td colspan="2">-&nbsp;<i><%=comment%></i></td>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--        }--%>
<%--    } else {--%>
<%--    %>--%>
    <tr><td colspan="2">暂无评论</td></tr>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>
    <!-- 分割不同帖子的空白行 -->
    <tr><td colspan="2" height="10"></td></tr>

    <%
    } else {
    %>

    <tr><td colspan="2">暂无帖子!</td></tr>
    <% } %>
</table>

<%--<!-- 新增评论表单部分 -->--%>
<%--<h3>添加评论</h3>--%>
<%--<form action="submitComment.jsp" method="post">--%>
<%--    <input type="hidden" name="postId" value="${currentPostId}">--%>
<%--    <label for="commentContent">评论内容:</label><br>--%>
<%--    <textarea id="commentContent" name="content" rows="4" cols="50" required></textarea><br>--%>
<%--    <input type="submit" value="提交评论">--%>
<%--</form>--%>
</body>
</html>

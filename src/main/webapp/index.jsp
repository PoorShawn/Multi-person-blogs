<%@ page import="org.poorman.blogs.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%--<a href="login.jsp">login</a>--%>

<a href="${pageContext.request.contextPath}/postIndex-servlet">posts list</a>
<%
    // 检查session中是否有用户,来判断用户是否登录
    boolean isLoggedIn = session.getAttribute("currentUser") != null;
%>

<% if (!isLoggedIn) { %>
<a href="login.jsp">login</a>
<% } %>

<% if (isLoggedIn) { %>
<a href="postEdit.jsp">edit post</a>
<% } %>

<%
    User user = (User) session.getAttribute("currentUser");
    if (isLoggedIn) {
%>
<a href="${pageContext.request.contextPath}/userManage-servlet">manage users</a>
<% } %>

<%--<a href="${pageContext.request.contextPath}/userManage-servlet">manage users</a>--%>
</body>
</html>
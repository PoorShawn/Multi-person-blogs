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
<a href="login.jsp">login</a>
<%
    // 检查session中是否有特定的属性，比如用户ID，来判断用户是否登录
    //HttpSession session = request.getSession(false);
    boolean isLoggedIn = session.getAttribute("currentUser") != null;
%>
<% if (isLoggedIn) { %>
<%--<a href="postUpload.jsp">upload post</a>--%>
<a href="postEdit.jsp">edit post</a>
<a href="${pageContext.request.contextPath}/postDisplay-servlet">display posts</a>
<% } %>
</body>
</html>
<%@ page import="org.poorman.blogs.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: poorshawn
  Date: 2024/6/12
  Time: 下午11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage users</title>
</head>
<body>
<h2>User Management</h2>
<%--<!-- 增加用户 -->--%>
<%--<form action="${pageContext.request.contextPath}/userManage-servlet" method="POST">--%>
<%--    <input type="hidden" name="action" value="add">--%>
<%--    <label>New User Name: <input type="text" name="newUsername"></label>--%>
<%--    <button type="submit">Add User</button>--%>
<%--</form>--%>

<table border="1">
    <tr>
        <th>ID</th>
        <th>UserName</th>
        <th>Role</th>
        <th>Action</th>
    </tr>
    <%
        List<User> userList = (List<User>) request.getAttribute("userList");
        if(userList != null) {
            for(User user : userList) {
    %>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getUsername() %></td>
        <td><%= user.getRole() %></td>
        <td>
            <% if("USER".equals(user.getRole())) { %>
            <a href='${pageContext.request.contextPath}/userRoleAlter-servlet?action=promote&userId=<%= user.getId() %>'>Promote</a>
            <% } else if("ADMIN".equals(user.getRole())) { %>
            <a href='${pageContext.request.contextPath}/userRoleAlter-servlet?action=demote&userId=<%= user.getId() %>'>Demote</a>
            <% } %>
            <a href='${pageContext.request.contextPath}/userRoleAlter-servlet?action=delete&userId=<%= user.getId() %>' onclick='return confirm(\"Confirm deletion?\");'>Delete</a>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr><td colspan='4'>No users found.</td></tr>
    <%
        }
    %>
</table>

<h3>增加用户</h3>
<%--<form action="${pageContext.request.contextPath}/userManage-servlet" method="POST">--%>
<%--    <input type="hidden" name="action" value="add">--%>
<%--    <label>New User's Name: <input type="text" name="username"></label>--%>
<%--    <label>New User's Password: <input type="text" name="password"></label>--%>
<%--    <label>New User's Role: <input type="text" name="role"></label>--%>
<%--    <button type="submit">Add User</button>--%>
<%--</form>--%>
<form action="${pageContext.request.contextPath}/userAdd-servlet" method="POST">
    <div>
        <label>New User's Name: <input type="text" name="username"></label>
    </div>
    <div>
        <label>New User's Password: <input type="text" name="password"></label>
    </div>
    <div>
        <label>New User's Role: <input type="text" name="role"></label>
    </div>
    <div>
        <button type="submit">Add User</button>
    </div>
</form>

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

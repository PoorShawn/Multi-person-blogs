<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: poorshawn
  Date: 2024/5/29
  Time: 上午9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<br/>
<form action="${pageContext.request.contextPath}/login-servlet" method="post">
    用户名：<input type="text" name="username" required><br>
    密码：<input type="password" name="password" required><br>
    <input type="submit" value="登录">
</form>
<br/>
    <%
        PrintWriter printWriter = response.getWriter();
        if(request.getAttribute("message")!= null){
            printWriter.write((String)request.getAttribute("message"));
            printWriter.flush();
        }
    %>

</body>
</html>

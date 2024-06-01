<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: poorshawn
  Date: 2024/5/30
  Time: 下午6:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>postSend</title>
</head>
<body>
<h2>请输入您的文本:</h2>
<form action="${pageContext.request.contextPath}/upload-servlet" method="post">
    <h3>标题</h3>
    <label>
        <textarea name="title" rows="1" cols="8" required></textarea>
    </label>
    <br/><br/>
    <h3>内容</h3>
    <label>
        <textarea name="contentText" rows="10" cols="30" required></textarea>
    </label>
    <br/><br/>
    <input type="submit" value="上传文本"/>
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

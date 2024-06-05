<%--
  Created by IntelliJ IDEA.
  User: poorshawn
  Date: 2024/6/5
  Time: 下午12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Please edit your post.</title>
</head>
<body>
<!-- Include stylesheet -->
<link href="css/quill.snow.css" rel="stylesheet" />

<!-- Create the editor container -->
<div id="editor">
    <p>Hello World!</p>
    <p>Some initial <strong>bold</strong> text</p>
    <p><br /></p>
</div>

<!-- Include the Quill library -->
<script src="js/quill.js"></script>
<!-- Initialize Quill editor -->
<script>
    const quill = new Quill('#editor', {
        theme: 'snow'
    });
</script>
</body>
</html>

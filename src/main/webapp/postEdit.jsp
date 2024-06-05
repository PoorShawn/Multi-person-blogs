<%@ page import="java.io.PrintWriter" %><%--
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
<link href="css/quill.snow.css" rel="stylesheet" />

<form id="postForm" action="${pageContext.request.contextPath}/upload-servlet" method="post">
    <h3>标题</h3>
    <label>
        <textarea name="title" rows="1" cols="8" required></textarea>
    </label>
    <br/><br/>
    <h3>内容</h3>
    <div id="editor" >
<%--        <p>Hello World!</p>--%>
<%--        <p>Some initial <strong>bold</strong> text</p>--%>
<%--        <p><br /></p>--%>
    </div>
    <input type="hidden" id="content" name="content" />
    <button onclick="submitForm()">Submit</button>
</form>

<%
    PrintWriter printWriter = response.getWriter();
    if(request.getAttribute("message")!= null){
        printWriter.write((String)request.getAttribute("message"));
        printWriter.flush();
    }
%>

<script src="js/quill.js"></script>
<script>
    var quill = new Quill('#editor', {
        modules: {
            toolbar: [
                ['bold', 'italic'],
                ['link', 'blockquote', 'code-block', 'image'],
                [{ list: 'ordered' }, { list: 'bullet' }]
            ]
        },
        theme: 'snow'
    });
    var form = document.querySelector('#postForm');
    form.onsubmit = function() {
        // Populate hidden form on submit
        var content = document.querySelector('input[name=content]');

        //comment.value = JSON.stringify(quill.getContents());
        content.value = quill.root.innerHTML;
        console.log(content.value)

    };
</script>
</body>
</html>

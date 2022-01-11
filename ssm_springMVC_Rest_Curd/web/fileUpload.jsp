<%--
  Created by IntelliJ IDEA.
  User: zls
  Date: 2022/1/11
  Time: 10:45:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传资源</title>
</head>
<body>
    <form action="fileUpload" method="post" enctype="multipart/form-data">
        <label>
            <input type="file" name="file" />
            <input type="text" name="desc" />
            <input type="submit" value="提交"/>
        </label>
    </form>
</body>
</html>

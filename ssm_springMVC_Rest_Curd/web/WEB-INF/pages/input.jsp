<%--
  Created by IntelliJ IDEA.
  User: zls
  Date: 2021/12/17
  Time: 10:28:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加员工信息</title>
</head>
<body>
<form class="forms" action="${pageContext.request.contextPath}/saveEmp" method="POST">
    <label>
        姓名：<input type="text" name="lastName"/>
    </label>
    <br>
    <label>
        email:<input type="text" name="email">
    </label>
    <br>
    <label>性别：
        <input type="radio" name="gender" value="1" checked>男
        <input type="radio" name="gender" value="0">女
    </label>
    <br/>
    <label>
        部门：<select name="department.id">
        <c:forEach var="dep" items="${departments}">
            <option value="${dep.id}">
                    ${dep.departmentName}
            </option>
        </c:forEach>
    </select>
    </label>
    <input type="submit" name="添加">
</form>
</body>
<style>
    body{
        margin:0;
    }
    .forms{
        text-align: center;
    }
</style>
</html>

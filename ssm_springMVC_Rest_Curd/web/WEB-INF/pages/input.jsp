<%--
  Created by IntelliJ IDEA.
  User: zls
  Date: 2021/12/17
  Time: 10:28:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加员工信息</title>
</head>
<body>
<%--使用spring表单标签优化添加页面--%>
<form:form class="forms" action="${pageContext.request.contextPath}/saveEmp" method="post" modelAttribute="employee">
<%--<form:form class="forms" action="${pageContext.request.contextPath}/saveEmp" method="post">--%>
    姓名：<form:input path="lastName" /><br>
    邮箱：<form:input path="email"/><br>
    性别：<form:radiobuttons path="gender" items="${genders}" checked="1"/><br>
    部门：<form:select path="department.id" items="${departments}" itemValue="id" itemLabel="departmentName"/><br>
    <input type="submit" value="Add">
</form:form>

<%--原页面--%>
<form class="forms" action="${pageContext.request.contextPath}/saveEmp" method="POST">
    姓名：<input type="text" name="lastName"/><br>
    email:<input type="text" name="email"><br>
    性别：<input type="radio" name="gender" value="1" checked>男
    <input type="radio" name="gender" value="0">女<br/>
    部门：<select name="department.id">
            <c:forEach var="dep" items="${departments}">
                <option value="${dep.id}">
                        ${dep.departmentName}
                </option>
            </c:forEach>
        </select>
    <input type="submit" name="添加">
</form>
</body>
<style>
    body {
        margin: 0;
    }
    .forms {
        text-align: center;
    }
</style>
</html>

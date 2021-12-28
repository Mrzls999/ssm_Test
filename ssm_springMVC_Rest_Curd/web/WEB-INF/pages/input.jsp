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
<c:if test="${empty employee.id}" var="yOn">
    <h2>添加员工信息</h2>
</c:if>
<c:if test="${!yOn}">
    <h2>修改员工信息</h2>
</c:if>
<br>
<%--使用spring表单标签优化添加页面--%>
<%--<form:form class="forms" action="${pageContext.request.contextPath}/saveEmp" method="post" modelAttribute="command">--%>
<form:form class="forms" action="${pageContext.request.contextPath}/saveEmp" method="post" modelAttribute="employee">
    <c:if test="${!yOn}"><%--如果employee的id不为空，则是修改--%>
        <form:input path="id" /><%--spring的hidden有回显功能，可以发送回去--%>
        <input type="hidden" name="_method" value="PUT"><%--html的hidden没有回显功能--%>
    </c:if>
    <h2>${yOn?1:0}</h2>
    姓名：<form:input path="lastName" /><br>
    邮箱：<form:input path="email"/><br>
    性别：<form:radiobuttons path="gender" items="${genders}" checked="${genders.enabled ? 'checked' : ''}"/><br>
    部门：<form:select path="department.id" items="${departments}" itemValue="id" itemLabel="departmentName" selected="${employee.department.id}"/><br>
    <c:if test="${yOn}">
        <input type="submit" value="添加">
    </c:if>
    <c:if test="${!yOn}">
        <input type="submit" value="修改">
    </c:if>
</form:form>
<br><br><br><br><br><br>
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
    h2{
        text-align:center;
    }
</style>
</html>

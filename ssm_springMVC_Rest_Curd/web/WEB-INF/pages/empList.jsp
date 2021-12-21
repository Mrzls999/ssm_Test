<%--
  Created by IntelliJ IDEA.
  User: zls
  Date: 2021/12/16
  Time: 14:51:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>员工信息</h2>
<table id="empList">
    <tr>
        <th>Id</th>
        <th>名字</th>
        <th>邮箱</th>
        <th>性别</th>
        <th>部门</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${requestScope.empList}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender==1?'男':'女'}</td>
            <td>${emp.department.departmentName}</td>
            <td>
                <a href="${pageContext.request.contextPath}/goEditEmpView/${emp.id}">Edit</a>&nbsp;|&nbsp;<a href="#">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr id="addEmp">
        <td colspan="6"><a href="${pageContext.request.contextPath}/getDep">Add</a></td>
    </tr>
</table>
</body>
<style>
    table{
        border:green 2px solid;
        text-align: center;
        margin: 0 auto;
    }
    td,th{
        border:1px green solid;
        padding:10px;
    }
    h2{
        text-align: center;
    }
    #addEmp{
        text-align: right;
    }
</style>
</html>

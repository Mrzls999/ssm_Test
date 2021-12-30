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
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.7.2min.js"></script>
    <script>
        $(function () {
            $(".delEmp").click(function () {//当点击删除链接时触发
                let delFlag = confirm("是否删除"+$(this).attr("name")+"的数据");
                if(delFlag){
                    let delHref = $(this).prop("href");//得到属性href
                    let delEmp = $("#delEmp");//得到form表单控制
                    delEmp.attr("action",delHref);//将得到的href属性值赋值给form表单
                    delEmp.submit();
                }
                return false;//取消连接的默认行为
            });
        });
    </script>
</head>
<body>
<h2>员工信息</h2>
<table id="empList">
    <form id="delEmp" action="#" method="POST"><!--用来删除emp信息-->
        <input type="hidden" name="_method" value="DELETE">
    </form>
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
                <a href="${pageContext.request.contextPath}/goEditEmpView/${emp.id}">Edit</a>&nbsp;|&nbsp;
<%--                <a href="${pageContext.request.contextPath}/delEmp/${emp.id}">Delete</a>使用的GET请求，应该使用DELETE--%>
                <a class = "delEmp" name="${emp.lastName}" href="${pageContext.request.contextPath}/delEmp/${emp.id}">Delete</a>
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

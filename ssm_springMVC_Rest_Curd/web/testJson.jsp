<%--
  Created by IntelliJ IDEA.
  User: zls
  Date: 2022/1/10
  Time: 14:01:38
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
            $("#testJson1").click(function () {
              $.ajax({
                  url:"${pageContext.request.contextPath}/testJson1",
                  type:"GET",
                  dataType:"json",
                  success:function (rs) {
                      for(let i=0;i<rs.length;i++){
                        $("#tableId").append(
                            "<tr>" +
                            "<td>"+rs[i].lastName+"</td>" +
                            "<td>"+rs[i].gender+"</td>" +
                            "<td>"+rs[i].email+"</td>" +
                            "<td>"+rs[i].department.departmentName+"</td>" +
                            "</tr>"
                        )
                      }
                  },
                  error:function(){
                      alert("error");
                  }
              });
              return false;
            })
            $("#testJson2").click(function () {
                let emp = {"id":"1001","lastName":"zls"};
                $.ajax({
                    url:"${pageContext.request.contextPath}/testJson2",
                    type: "post",
                    contentType:"application/json",
                    data:JSON.stringify(emp),
                    dataType: "json",
                    success:function (rs) {
                        console.log(rs.lastName);
                    },
                    error:function () {
                        alert("error");
                    }
                });
                return false;
            })
        });
    </script>
</head>
<body>
    <form>
        <table id = "tableId">
        </table>
    </form>
<a id = "testJson1" href="${pageContext.request.contextPath}/testJson1">前端处理服务器发送过来的json数据</a><br/>
<a id = "testJson2" href="${pageContext.request.contextPath}/testJson2">向服务器发送json格式的数据</a>
</body>
<style>
    #tableId{
        border: green 1px solid;
    }
    td{
        border: green 1px solid;
        padding: 10px;
    }
</style>
</html>

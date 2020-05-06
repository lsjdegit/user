<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/4/15
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 登陆成功
 ${us.username}
<table border="1">
    <tr><td>姓名</td><td>密码</td><td>邮箱</td><td>操作</td></tr>
    <c:forEach items="${listuser}" var="ua">
        <tr>
            <td>${ua.username}</td>
            <td>${ua.userpassword}</td>
            <td>${ua.useremail}</td>
            <td colspan="2">删除 修改</td>
        </tr>

    </c:forEach>
</table>
</body>
</html>

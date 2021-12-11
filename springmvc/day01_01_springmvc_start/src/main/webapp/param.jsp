<%--
  Created by IntelliJ IDEA.
  User: 卢玉洁
  Date: 2021/12/9
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定</title>
</head>
<body>
<!--
<form action="param/saveAccount" method="post">
    姓名:<input type="text" name="username"/><br/>
    密码:<input type="text" name="password"/><br/>
    金额:<input type="text" name="money"/><br/>
    用户姓名:<input type="text" name="user.uname"/><br/>
    用户年龄:<input type="text" name="user.age"/><br/>
    <input type="submit" value="提交">
</form>
-->
<%--<form action="param/saveAccount" method="post">--%>
    <%--姓名:<input type="text" name="username"/><br/>--%>
    <%--密码:<input type="text" name="password"/><br/>--%>
    <%--金额:<input type="text" name="money"/><br/>--%>
    <%--&lt;%&ndash;    把下面的数据封装成一个User对象，然后把该User对象存入List集合&ndash;%&gt;--%>
    <%--用户姓名：<input type="text" name="list[0].uname"></br>--%>
    <%--用户年龄：<input type="text" name="list[0].age"></br>--%>
    <%--&lt;%&ndash;    把下面的数据封装成一个User对象，然后把该User对象存入Map集合&ndash;%&gt;--%>
    <%--用户姓名：<input type="text" name="map['one'].uname"></br>--%>
    <%--用户年龄：<input type="text" name="map['one'].age"></br>--%>
    <%--<input type="submit" value="提交">--%>
<%--</form>--%>

<%--<form action="param/saveUser" method="post">--%>
    <%--姓名:<input type="text" name="uname"/><br/>--%>
    <%--密码:<input type="text" name="age"/><br/>--%>
    <%--出生日期:<input type="text" name="date">--%>
    <%--<input type="submit" value="提交">--%>
<%--</form>--%>

<a href="param/testServlet">拿到原生servletApi</a>
</body>
</html>

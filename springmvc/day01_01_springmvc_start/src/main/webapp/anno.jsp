<%--
  Created by IntelliJ IDEA.
  User: 卢玉洁
  Date: 2021/12/10
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试注解</title>
</head>
<body>
<a href="anno/testRequestParam?name=hehe">testRequestParam</a>


<form action="anno/testRequestBody" method="post">
姓名:<input type="text" name="uname"/><br/>
密码:<input type="text" name="age"/><br/>
<input type="submit" value="提交"><br/>
</form>

<a href="anno/testPathVariable/4">testPathVariable</a>

<form action="anno/testModelAttribute" method="post">
    用户姓名：<input type=" text" name="uname"><br/>
    用户年龄:<input type="text" name="age"><br/>
    <input type="submit" value="提交">
</form>

<a href="anno/testSessionAttributes">testSessionAttributes</a>
<a href="anno/getSessionAttributes">getSessionAttributes</a>
<a href="anno/delSessionAttributes">delSessionAttributes</a>

</body>
</html>

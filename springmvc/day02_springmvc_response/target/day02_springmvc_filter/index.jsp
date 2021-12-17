<%--
  Created by IntelliJ IDEA.
  User: 卢玉洁
  Date: 2021/12/11
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>返回值类型</title>

    <script src="js/jquery-3.2.0.min.js"></script>
    <script>
        //页面加载，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                // alert("hello btn");
                //发送ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                    url: "user/testAjax",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"username":"hehe","password":"123","age":"21"}',
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        //data：服务器端响应的json数据
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });
        });
    </script>

</head>
<body>

<button id="btn">发送ajax的请求</button>
<a href="user/testString">testString</a>

<a href="user/testVoid">testVoid</a>

</body>
</html>

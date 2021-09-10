<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script>
        $(function () {
            $("#submit").on('click', function () {
                $.ajax({
                    url: "/login",
                    type: 'POST',
                    data: {'phone': $("#phone").val(), 'passWord': $("#password").val(), 'iscontroller': $("#iscontroller").val()},
                    success: function (data) {
                        alert(data);
                    }
                });
            })
        });

    </script>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body><!-------------------login-------------------------->
<div class="login">
    <form><h1><a href="index.html"><img src="img/temp/logo.png" width="100" height="100"></a></h1>
        <p></p>
        <div class="msg-warn hide"><b></b>公共场所不建议自动登录，以防账号丢失</div>
        <p><input type="text" name="userName" value="" placeholder="昵称/邮箱/手机号"></p>
        <p><input type="text" name="passWord" value="" placeholder="密码"></p>
        <p>
            <input style="width:15px;height:15px" type="radio" name="iscontroller" value="T" checked="checked">管理员
            <input style="width:15px;height:15px" type="radio" name="iscontroller" value="F" >普通用户
        </p>
        <p><input type="submit" name="" value="登  录"></p>
        <p class="txt"><a href="${pageContext.request.contextPath}/registryPage">还没注册？</a><a href="forget.html">忘记密码？</a></p></form>
</div>
</body>
</html>
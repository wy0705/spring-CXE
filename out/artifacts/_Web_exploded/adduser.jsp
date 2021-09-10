<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/calendar.js"></script>
    <script src="js/function.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script>

        $(function () {
            $("#submit").on('click', function () {
                $.ajax({
                    url: "/adduser",
                    type: 'POST',
                    data: {'name': $("#userName").val(),'name': $("#name").val(),'birthday': $("#birthday").val()
                        ,'email': $("#birthday").val() ,'mobile': $("#mobile").val() ,'address': $("#address").val() ,'getcode': $("#getcode").val()},
                    success: function (data) {
                        alert(data);
                    }
                });
            })
        });

    </script>

    <style>
        .reg p .error {
            display:inline-block;
            border:1px solid #ff855a;
            background-color:#ffe8e0;
            height:25px;
            line-height:25px;
            padding:0px 20px;
            margin-left:20px;
        }
    </style>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post" onsubmit="return checkForm(this)"><h1><a href="index.html"><img src="img/temp/logo.png" width="100" height="100"></a></h1>
        <p><input type="text" name="userName" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入用户名"><span></span></p>
        <p><input type="text" name="name" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入姓名"><span></span></p>

        <p><input type="text" name="birthday" value="" onfocus="c.show(this)" placeholder="请输出生日期"><span></span></p>
        <p><input type="text" name="email" value="" placeholder="请输入邮箱"><span></span></p>
        <p><input type="text" name="mobile" value="" placeholder="请输入手机号码"><span></span></p>
        <p><input type="text" name="address" value="" placeholder="所在城市"><span></span></p>
        <p><input class="code" type="text" name="veryCode" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="验证码">
            <img height="25" src="getcode" alt="看不清，换一张" onclick="change(this)"><span></span></p>
        <p><input type="submit" name="" value="实名认证"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略></a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: lxh
  Date: 2021/7/14
  Time: 上午10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>

<head>
    <meta charset="utf-8">
    <title>提示框</title>
    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="jqueryui/style.css">
    <script>
        $(function() {
            $( "#dialog-modal" ).dialog({
                height: 140,
                modal: true
            });
        });
    </script>
</head>
<body>

<div id="dialog-modal" title="温馨提示！">
    <p><a href="login.jsp" style="align-content: center">请点击进行登录后再提交申请</a></p>
</div>


</body>
</html>
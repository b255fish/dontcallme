<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%@ page import="java.net.*, java.io.*" %>
<%@ page import="org.apache.commons.dbcp2.BasicDataSource" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="css/bootstrap-4.3.1.min.css">
    <link rel="stylesheet" href="css/custom.css">
    <title>캡스톤디자인프로젝트</title>


    <script src='https://www.google.com/recaptcha/api.js'></script>
    <script type="text/javascript"> /* 서브밋 전에 리캡챠 체크 여부 를 확인합니다. */
    function FormSubmit() {
        if (grecaptcha.getResponse() == "") {
            alert("리캡챠를 체크해야 합니다.");
            return false;
        } else {
            return true;
        }
    }
    </script>

    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-148884809-2"></script>
    <script>
        window.dataLayer = window.dataLayer || [];

        function gtag() {
            dataLayer.push(arguments);
        }

        gtag('js', new Date());

        gtag('config', 'UA-148884809-2');
    </script>


</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="mainAction.jsp">IoT SSS</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#top-menu"
            aria-controls="top-menu" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="top-menu">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="mainAction.jsp">스트리밍 서비스 </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="info.jsp">대시보드<span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
    <div class="nav-item dropdown ml-auto">
        <a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true"
           aria-expanded="false">
            접속하기<span class="caret"></span></a>
        <div class="dropdown-menu">
            <a class="dropdown-item active" href="login.jsp">로그인</a>
            <a class="dropdown-item" href="join.jsp">회원가입</a>
        </div>
    </div>
</nav>


<div class="container">
    <div class="jumbotron">
        <div class="container">
            <h1>IoT SSS</h1>
            <p>IoT 단말기 스트리밍 보안 솔루션</p>
        </div>
    </div>
</div>


<div class="container">
    <!--
        <div class="col-lg-4"></div>
        <div class="col-lg-4">-->

    <div class="jumbotron" style="padding-top: 20px;">
        <center>
            <form method="post" action="loginAction.jsp" onsubmit="return FormSubmit();">
                <h3 style="text-align: center;">로그인 화면</h3>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="IP주소" name="userIP" maxlength="50">
                </div>
                <input type="submit" class="btn btn-primary form-control" value="로그인"> <br/>
                <br/>
                <div id="html_element" class="g-recaptcha" data-sitekey="6LfcBroUAAAAAMq9QgxvgprKBVxV15KZHIhsQM73"
                     style="margin:0 auto;"></div>
            </form>
        </center>
    </div>
    <!--
</div>
<div class="col-lg-4"></div> -->
</div>

<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap-4.3.1.min.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="css/bootstrap-4.3.1.min.css">
    <link rel="stylesheet" href="css/custom.css">
    <title>캡스톤디자인프로젝트</title>


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
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="mainAction.jsp">스트리밍 서비스 </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="info.jsp">대시보드<span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <ul class="nav-item dropdown ml-auto">
            <a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true"
               aria-expanded="false">
                접속하기<span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a class="dropdown-item active" href="login.jsp">로그인</a></li>
                <li><a class="dropdown-item" href="join.jsp">회원가입</a></li>
            </ul>
        </ul>
    </div>
</nav>


<div class="container">
    <div class="jumbotron" style="padding-top: 20px;">
        <form method="post" action="joinAction.jsp">
            <h3 style="text-align: center;">회원가입 화면</h3>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="이름" name="userName" maxlength="20">
            </div>
            <!--
            <div class="form-group" style="text-align: center;">
                <div class="btn-group" data-toggle="buttons">
                    <label class="btn btn-primary active">
                        <input type="radio" name="userGender" autocomplete="off" value="남자" checked>남자
                    </label>
                    <label class="btn btn-primary">
                        <input type="radio" name="userGender" autocomplete="off" value="여자">여자
                    </label>
                </div>
            </div>
             -->
            <div class="form-group">
                <input type="email" class="form-control" placeholder="이메일" name="userEmail" maxlength="50">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="IP주소" name="userIP" maxlength="50">
            </div>
            <input type="submit" class="btn btn-primary form-control" value="회원가입">
        </form>
    </div>
</div>
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap-4.3.1.min.js"></script>
</body>
</html>
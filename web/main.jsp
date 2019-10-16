<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="user.UserDAO" %>
<%@ page import="java.security.GeneralSecurityException" %>

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
<%

    String userID = null;
    String userIP = null;

    if (session.getAttribute("userID") != null) {
        userID = (String) session.getAttribute("userID");
    }
    if (session.getAttribute("userIP") != null) {
        userIP = (String) session.getAttribute("userIP");
    }
    if (userID == null) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('로그인을 해주세요.');");
        script.println("location.href = 'login.jsp'; ");
        script.println("</script>");
        script.close();
        return;
    }
    boolean emailChecked = false;
    try {
        emailChecked = new UserDAO().getUserEmailChecked(userID);
    } catch (GeneralSecurityException e) {
        e.printStackTrace();
    }
    if (!emailChecked) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("location.href = 'emailSendConfirm.jsp'; ");
        script.println("</script>");
        script.close();
        return;
    }

%>

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
            회원관리<span class="caret"></span></a>
        <div class="dropdown-menu">
            <a class="dropdown-item active" href="logoutAction.jsp">로그아웃</a>
            <a class="dropdown-item" onclick="return confirm('정말로 탈퇴하시겠습니까?')" href="removeAction.jsp">회원탈퇴</a>
        </div>
    </div>
</nav>

<div class="container" style=width:1380px;>
    <div class="jumbotron">
        <div class="container">
            <h1>IoT SSS</h1>
            <p>IoT 단말기 스트리밍 보안 솔루션</p>
        </div>
    </div>
</div>
<div class="container" style=width:1380px;>
    <div class="jumbotron" style="width: 1380px">
        <h1>스트리밍 서비스</h1>
        <br/>
        <br/>
        <div class="jumbotron" style="padding:10px;">
            <h3 style="text-align: center;"><%=userID %>의 이지엔 ES100V Mini</h3>
            <br/>
            <p align="center">
                <iframe src="http://<%=userIP %>:6611/web/admin.html" width=1230px height=800px frameborder=0
                        framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
            </p>
        </div>
    </div>
</div>
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap-4.3.1.min.js"></script>
</body>
</html>
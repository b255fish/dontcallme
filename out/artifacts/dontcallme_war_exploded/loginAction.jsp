<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.security.GeneralSecurityException" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.UserDTO" scope="page"/>
<jsp:setProperty name="user" property="userID"/>
<jsp:setProperty name="user" property="userPassword"/>
<jsp:setProperty name="user" property="userIP"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
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
    if (userID != null) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('이미 로그인이 되어있습니다.')");
        script.println("location.href = 'main.jsp'");
        script.println("</script>");
    }

    UserDAO userDAO = new UserDAO();
    int result = 0;
    try {
        result = userDAO.login(user.getUserID(), user.getUserPassword(), user.getUserIP());
    } catch (GeneralSecurityException e) {
        e.printStackTrace();
    }
    if (result == 1) {
        session.setAttribute("userID", user.getUserID());
        session.setAttribute("userIP", user.getUserIP());
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("location.href = 'main.jsp'");
        script.println("</script>");
    } else if (result == 0) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('비밀번호가 틀립니다.')");
        script.println("history.back()");
        script.println("</script>");
    } else if (result == -1) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('아이디 혹은 IP주소가 존재하지 않습니다.')");
        script.println("history.back()");
        script.println("</script>");
    } else if (result == -2) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('데이터베이스 오류가 발생했습니다.')");
        script.println("history.back()");
        script.println("</script>");
    }
%>
</body>
</html>
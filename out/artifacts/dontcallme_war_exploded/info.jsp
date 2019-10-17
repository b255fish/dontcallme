<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="user.UserDAO" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="util.DatabaseUtil" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="css/bootstrap.css">
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

<jsp:useBean id="counter" class="util.CounterBean" scope="application"/>
<jsp:setProperty name="counter" property="newVisit" value="1"/>
<%

    String userID = null;
    String userName = null;
    String userEmail = null;
    if (session.getAttribute("userID") != null) {
        userID = (String) session.getAttribute("userID");
    }
    if (session.getAttribute("userName") != null) {
        userName = (String) session.getAttribute("userName");
    }
    if (session.getAttribute("userEmail") != null) {
        userEmail = (String) session.getAttribute("userEmail");
    }
    if (userID == null) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('로그인을 해주세요..');");
        script.println("location.href = 'login.jsp'; ");
        script.println("</script>");
        script.close();
        return;
    }
    boolean emailChecked = new UserDAO().getUserEmailChecked(userID);
    if (emailChecked == false) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("location.href = 'emailSendConfirm.jsp'; ");
        script.println("</script>");
        script.close();
        return;
    }




    try (Connection conn = DatabaseUtil.getDataSource().getConnection()) {
        String sql1 = "select * from CCTV where userID = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql1);

        Statement stmt = null;
        pstmt.setString(1, userID);
        stmt = conn.createStatement();
        String sql2 = "select * from CCTV where userID = '" + userID + "'";
        ResultSet rs = stmt.executeQuery(sql2);

        if (rs.next()) {
            userName = rs.getString("userName");
            userEmail = rs.getString("userEmail");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // 5. rs => 변수저장, 출력

    Date nowTime = new Date();
    SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");


%>
<nav class="navbar navbar-default">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed"
                data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                aria-expanded="false">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="mainAction.jsp">IoT SSS</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li><a href="mainAction.jsp">스트리밍 서비스</a></li>
            <li class="active"><a href="info.jsp">대시보드</a></li>
        </ul>
        <%
            if (userID == null) {
        %>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle"
                   data-toggle="dropdown" role="button" aria-haspopup="true"
                   aria-expanded="false">접속하기<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="login.jsp">로그인</a></li>
                    <li><a href="join.jsp">회원가입</a></li>
                </ul>
            </li>
        </ul>
        <%
        } else {
        %>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle"
                   data-toggle="dropdown" role="button" aria-haspopup="true"
                   aria-expanded="false">회원관리<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="logoutAction.jsp">로그아웃</a></li>
                    <li><a onclick="return confirm('정말로 탈퇴하시겠습니까?')" href="removeAction.jsp">회원탈퇴</a></li>
                </ul>
            </li>
        </ul>
        <%
            }
        %>
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
    <div class="jumbotron">
        <div class="container">
            <h1>대시보드</h1>
            <br/>
            <br/>

        <!-- 여기 순서 대략 바꿈 191016_1/3 -->
            <div class="row" style="text-align:center;">
                <div class="col-md-4 col-lg-4">
                    <div class="jumbotron" style="padding: 30px;">
                        <p>시스템 보안 솔루션 <br/>
                            <br/>
                        <div class="jumbotron" style="padding: 20px; background-color: white; color: black;">
                            컨테이너 보안
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-4">
                    <div class="jumbotron" style="padding: 30px;">
                        <p>네트워크 보안 솔루션 <br/>
                            <br/>
                        <div class="jumbotron" style="padding: 20px; background-color: white; color: black;">
                            라우터 보안
                        </div>
                        <div class="jumbotron" style="padding: 20px; background-color: white; color: black;">
                            IoT 단말 보안
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-4">
                    <div class="jumbotron" style="padding: 30px;">
                        <p>웹 보안 솔루션 <br/>
                            <br/>
                        <div class="jumbotron" style="padding: 20px; background-color: white; color: black;">
                            코드 보안
                        </div>
                        <div class="jumbotron" style="padding: 20px; background-color: white; color: black;">
                            브라우저 보안
                        </div>
                    </div>
                </div>

                <div class="col-md-4 col-lg-4">
                    <div class="jumbotron" style="padding: 30px;">
                        <p>회원 정보<br/>
                            <br/>
                        <div class="jumbotron" style="padding: 20px; background-color: white; color: black;">
                            <%=userName %>
                        </div>
                        <div class="jumbotron" style="padding: 20px; background-color: white; color: black;">
                            <%=userEmail %>
                        </div>
                    </div>
                </div>

                <div class="col-md-4 col-lg-4">
                    <div class="jumbotron" style="padding: 30px;">
                        <p>현재 날짜와 시간 <br/>
                            <br/>
                        <div class="jumbotron" style="padding: 20px; background-color: white; color: black;">
                            <%= sf.format(nowTime) %>
                        </div>
                    </div>
                </div>

                <div class="col-md-4 col-lg-4">
                    <div class="jumbotron" style="padding: 30px;">
                        <p>총 방문자수 <br/>
                            <br/>
                        <div class="jumbotron" style="padding: 20px; background-color: white; color: black;">
                            <jsp:getProperty name="counter" property="visitCount"/>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>


<%--

		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		// 1. 드라이버 로딩
		Class.forName("com.mysql.jdbc.Driver");
		// 2. DB 연결
		//String sql2 = "select * from CCTV where id = '" + userID + "'";
		conn = DatabaseUtil.getConnection();
		//pstmt = conn.prepareStatement(sql2);
		// 3. sql  id에 해당하는 모든정보 가져오기
		String sql = "select * from CCTV where userID = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userID);

		stmt = conn.createStatement();

		// 4. rs 실행 저장
		//rs = pstmt.executeQuery();
		String sql2 = "select * from CCTV where userID = '" + userID + "'";
		rs = stmt.executeQuery(sql2);

		// 5. rs => 변수저장, 출력
		if (rs.next()) {
			userName = rs.getString("userName");
			userEmail = rs.getString("userEmail");
		}

		Date nowTime = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
--%>
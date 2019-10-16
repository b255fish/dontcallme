<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="user.UserDAO" %>
<%@ page import="java.security.GeneralSecurityException" %>

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
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-148884809-2');
</script>

</head>
<body>
	<%

	String userID = null;
	String userIP = null;
	
	if(session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}
	if(session.getAttribute("userIP") != null) {
		userIP = (String) session.getAttribute("userIP");
	}
	if(userID == null) {
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
		if(!emailChecked) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'emailSendConfirm.jsp'; ");
			script.println("</script>");
			script.close();
			return;
		}
		
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
					<li class="active"><a href="mainAction.jsp">스트리밍 서비스</a></li>
				<li><a href="info.jsp">대시보드</a></li>			
			</ul>
			<%
				if(userID == null) {
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

	<!-- 여기 카메라 레이아웃 자바스크립트 191016_3/4 -->
	<script type="text/javascript">
		//<![CDATA[
		function calcHeight(){
			//find the height of the internal page

			var the_height=
					document.getElementById('the_iframe').contentWindow.
							document.body.scrollHeight;

			//change the height of the iframe
			document.getElementById('the_iframe').height=
					the_height;

			//document.getElementById('the_iframe').scrolling = "no";
			document.getElementById('the_iframe').style.overflow = "hidden";
		}
		//
	</script>

	<div class="container">
		<div class="jumbotron"">
			<h1>스트리밍 서비스</h1>
			<br />
			<br />
			<div class="jumbotron">
					<h3 style="text-align: center;"><%=userID %>의 이지엔 ES100V Mini</h3>
					<br />
				<!-- 태그속성 추가 + 자바스크립트 191016_4/4 -->
					<iframe src="http://<%=userIP %>:6611/web/admin.html" id="the_iframe" onload="calcHeight();" name="WrittenPublic" title="게시판뷰" style="overflow-x:hidden; overflow:auto; width:100%; min-height:500px;" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
			</div>
		</div>	
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>
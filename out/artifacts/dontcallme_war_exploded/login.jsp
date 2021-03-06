<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>캡스톤디자인프로젝트</title>


<script src='https://www.google.com/recaptcha/api.js'></script> 
<script type="text/javascript"> /* 서브밋 전에 리캡챠 체크 여부 를 확인합니다. */ 
function FormSubmit() { if (grecaptcha.getResponse() == "")
{ 
	alert("리캡챠를 체크해야 합니다."); return false; } else { return true; 
	} 
} 
	</script>
	
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
				<li><a href="info.jsp">대시보드</a></li>	
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="active"><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
					</ul>
				</li>
			</ul>
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
                    <br/>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20">
					</div>
					<input type="submit" class="btn btn-primary form-control" value="로그인"> <br />
					<br />
					<div id="html_element" class="g-recaptcha" data-sitekey="6LcUGL4UAAAAAHQDXJveqB7FG3uS9ih1mqa2FNF3"
					style="margin:0 auto;"></div>
				</form>
			</center>
			</div>
			<!-- 
		</div>
		<div class="col-lg-4"></div> -->
	</div>

	<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
			<script src="js/bootstrap.js"></script></body>
</html>
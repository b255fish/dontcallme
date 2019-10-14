<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="user.UserDTO" %>
<%@ page import="util.SHA256"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.regex.Matcher" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.security.GeneralSecurityException" %>
<%@ page import="org.apache.commons.dbcp2.BasicDataSource" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		String userPassword = null;
		String userName = null;
		String userGender = null;
		String userEmail = null;
		String userIP = null;

		if(request.getParameter("userID") != null) {
			userID = request.getParameter("userID");
		}
		if(request.getParameter("userPassword") != null) {
			userPassword = request.getParameter("userPassword");
		}
		if(request.getParameter("userName") != null) {
			userName = request.getParameter("userName");
		}
		//if(request.getParameter("userGender") != null) {
		//	userGender = request.getParameter("userGender");
		//}
		if(request.getParameter("userEmail") != null) {
			userEmail = request.getParameter("userEmail");
		}
		if(request.getParameter("userIP") != null) {
			userIP = request.getParameter("userIP");
		}
		if(userID == null || userPassword == null ||  userName == null ||
				userEmail == null || userIP == null || userID.equals("") ||
				userPassword.equals("") || userName.equals("") ||
				userEmail.equals("") || userIP.equals("")) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안 된 사항이 있습니다.');");
			script.println("history.back();");
			script.println("</script>");
			script.close();
			return;
		}
		else {
			Pattern pwPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$");
			Matcher matcher1 = pwPattern.matcher(userPassword);

			Pattern emailPattern = Pattern.compile("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$");
			Matcher matcher2 = emailPattern.matcher(userEmail);

			if (matcher1.matches() == false) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('8~20자 영문+숫자+특수문자를 사용하세요.')");
				script.println("history.back()");
				script.println("</script>");
			}
			else if (matcher2.matches() == false) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('잘못된 이메일 형식입니다.')");
				script.println("history.back()");
				script.println("</script>");
			}
			else {
				UserDAO userDAO = new UserDAO();
				//int result = userDAO.join(user);

				int result = 0;

				try {
					result = userDAO.join(new UserDTO(userID, userPassword, userName, userGender, userEmail, SHA256.getSHA256(userEmail), false, userIP));
				} catch (GeneralSecurityException e) {
					e.printStackTrace();
				}

				if (result == -1) {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('이미 존재하는 아이디입니다.')");
					script.println("history.back()");
					script.println("</script>");
				}
				else {
					session.setAttribute("userID", userID);
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("location.href = 'emailSendAction.jsp'");
					script.println("</script>");
				}
			}
		}
	%>
</body>
</html>
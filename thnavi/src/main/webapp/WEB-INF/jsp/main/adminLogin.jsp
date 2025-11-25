<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<form action="/loginAction" method="post" name="loginForm">
		<table>
			<tr>
				<td>ID</td>
				<td>
					<input id="userId" name="userId" type="text">
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<input id="userPw" name="userPw" type="password">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button id="btn_login" type="submit">Login</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
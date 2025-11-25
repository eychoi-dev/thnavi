<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<h1>관리자 메인</h1>
	<p>${sessionScope.loginInfo.USER_NAME}</p>
	<button></button>
</body>
</html>
<script type="text/javascript">
var loginInfo = ${sessionScope.loginInfo};

$(function() {
	console.log("loginInfo : ", loginInfo);
});
</script>
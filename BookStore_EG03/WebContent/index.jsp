<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
</head>
<body>
<!-- 用于转发到list页面 -->
	<jsp:forward page="/BookClientServlet?method=getPageIndex&pageNumber=1"></jsp:forward>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<style type="text/css">
h1 {
	text-align: center;
	margin-top: 200px;
}

h1 a {
	color: red;
}

input {
	text-align: center;
}
</style>
</head>
<body>
	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">编辑图书</span>
		<div>
			<%@ include file="/WEB-INF/include/manager_head.jsp" %>
		</div>
	</div>

	<div id="main">
		<form action="Manager/ManagerBookServlet" method="post">
		<input hidden="true" value="editBook" name="method">
		<input hidden="true" value="${requestScope.book.id }" name="id">
		<input hidden="true" value="${requestScope.book.imgPath }" name="img_path">
		<input hidden="true" value="${requestScope.referer }" name="referer">
			<table>
				<tr>
					<td>名称</td>
					<td>价格</td>
					<td>作者</td>
					<td>销量</td>
					<td>库存</td>
					<td colspan="2">操作</td>
				</tr>
				<tr>
					<td><input name="title" type="text" value="${requestScope.book.title }" /></td>
					<td><input name="price" type="text" value="${requestScope.book.price }" /></td>
					<td><input name="authot" type="text" value="${requestScope.book.authot }" /></td>
					<td><input name="sales" type="text" value="${requestScope.book.sales }" /></td>
					<td><input name="stock" type="text" value="${requestScope.book.stock }" /></td>
					<td><input name="book_amount" type="submit" value="提交" /></td>
				</tr>
			</table>
		</form>


	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>
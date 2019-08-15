<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
//查找删除a标签，点击给出提示
$(function(){
	//给删除绑定单击事件
	$(".delA").click(function(){
		//点击时查看图书标题
		var $title = $(this).parents("tr").children(":eq(0)").text();
		if(!confirm("你真的要删除《"+$title+"》吗？")){
			//取消删除
			//取消a标签的默认行为
			return false;
		}
	});
});
	

</script>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">图书管理系统</span>
		<div>
			<%@ include file="/WEB-INF/include/manager_head.jsp" %>
		</div>
	</div>

	<div id="main">
		<table>
			<c:choose>
				<c:when test="${empty requestScope.page }">
					<tr>
						<td colspan="7" align="center"><h3>书已经卖完了，正在抓紧补货</h3></td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>
					<c:forEach items="${requestScope.page.date }" var="book">
						<tr>
							<td>${book.title }</td>
							<td>${book.price }</td>
							<td>${book.authot }</td>
							<td>${book.sales }</td>
							<td>${book.stock }</td>
							<td><a href="Manager/ManagerBookServlet?method=getEditBook&bookId=${book.id }"">修改</a></td>
							<td><a class="delA" href="Manager/ManagerBookServlet?method=delBook&bookId=${book.id }">删除</a></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_add.jsp">添加图书</a></td>
			</tr>
		</table>
		<%@ include file="/WEB-INF/include/nav.jsp" %>
	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>
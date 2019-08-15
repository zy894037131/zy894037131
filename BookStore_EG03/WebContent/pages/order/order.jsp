<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<style type="text/css">
h1 {
	text-align: center;
	margin-top: 200px;
}
</style>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="/static/img/logo.gif"> <span
			class="wel_word">我的订单</span>
		<div>
			<%@ include file="/WEB-INF/include/user_head.jsp"%>
		</div>
	</div>

	<div id="main">
		<c:choose>
			<c:when test="${empty requestScope.order }">
				<h3>抓紧购买你喜欢的商品吧！！！</h3>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<td>订单号</td>
						<td>日期</td>
						<td>金额</td>
						<td>状态</td>
						<td>详情</td>
					</tr>
					<c:forEach items="${requestScope.order}" var="order">
						<tr>
							<td>${order.id }</td>
							<td><fmt:formatDate value="${order.dateTime }" dateStyle="full"/></td>
							<td>${order.totalAmount }</td>
							<c:if test="${order.state==0 }">
								<td>未发货</td>
							</c:if>
							<c:if test="${order.state==1 }">
								<td><a href="OrderClientServlet?method=updateOrderState&orderId=${order.id }">确认收货</a></td>
							</c:if>
							<c:if test="${order.state==2 }">
								<td>收获完成</td>
							</c:if>
							<td><a href="#">查看详情</a></td>
						</tr>

					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
		<c:if test="${empty sessionScope.user }">
			<h3>请登录查看订单状态！！！</h3>
		</c:if>
	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>
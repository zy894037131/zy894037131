<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="/static/img/logo.gif"> <span
			class="wel_word">订单管理系统</span>
		<div>
			<%@ include file="/WEB-INF/include/manager_head.jsp"%>
		</div>
	</div>

	<div id="main">

		<c:choose>
			<c:when test="${empty requestScope.allOrder }">
				<h3>客户还没有下单呦！！！</h3>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<td>订单号</td>
						<td>日期</td>
						<td>金额</td>
						<td>详情</td>
						<td>发货</td>
					</tr>
					<c:forEach items="${requestScope.allOrder }" var="order">
						<tr>
							<td>${order.id }</td>
							<td>${order.dateTime }</td>
							<td>${order.totalAmount }</td>
							<td>
							<c:if test="${order.state==0 }"><a href="OrderManagerServlet?method=updateOrderState&orderId=${order.id }">点击发货</a></c:if>
							<c:if test="${order.state==1 }">等待客户签收</c:if>
							<c:if test="${order.state==2 }">订单已完成</c:if>
							</td>
							<td><a href="#">查看详情</a></td>
						</tr>

					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>

	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	$(function(){
		$(".totalCount").change(function(){
			var val=$(this).val();
			var bookId=$(this).attr("id");
			var $amountTd = $(this).parents("tr").find("td:eq(3)");
			if(isNaN(val)){
				alert("请输入正确的数字");
				$(this).attr("value", this.defaultValue);
				return false;
			}else{
				$.post("${pageContext.request.contextPath}/CartServlet",{"method":"updateCount","bookId":bookId,"totalCount":val},function(result){
					alert(result.totalPrice);
					console.log(result.totalPrice);
					$(".b_count").text(result.totalBookCount);
					$(".b_price").text(result.totalBookPrice);
					$amountTd.text(result.totalPrice);
				},"json");
				}
			});
			//window.location="${pageContext.request.contextPath}/CartServlet?method=updateCount&bookId="+bookId+"&totalCount="+val;
		})
	

</script>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">购物车</span>
		<div>
			<%@ include file="/WEB-INF/include/user_head.jsp" %>
		</div>
	</div>

	<div id="main">
		<c:choose>
			<c:when test="${empty sessionScope.cart.cartItemList }">
				<h3>抓紧添加您喜欢的图书吧！！！</h3>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<td>商品名称</td>
						<td>数量</td>
						<td>单价</td>
						<td>金额</td>
						<td>操作</td>
					</tr>
					<!-- el表达式就是在调用get方法
						调用方法获得map的list但getCartItemList方法要去除get开头小写
					 -->
					<c:forEach items="${sessionScope.cart.cartItemList }" var="item">
						<tr>
							<td>${item.book.title }</td>
							<td><input name="totalCount" id="${item.book.id }" value="${item.totalCount }" style="width: 30px;" text-align="center" class="totalCount"/></td>
							<td>${item.book.price }</td>
							<td id="td${item.book.id }">${item.totalPrice }</td>
							<td><a href="CartServlet?method=delBook&bookId=${item.book.id }">删除</a></td>
						</tr>

					</c:forEach>
				</table>
				<div class="cart_info">
					<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalBookCount }</span>件商品
					</span> <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalBookPrice }</span>元
					<span><a href="CartServlet?method=clearCart">清空购物车</a></span>
					</span> <span class="cart_span"><a href="OrderClientServlet?method=saveOrder">去结账</a></span>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>
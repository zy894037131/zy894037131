<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
$(function(){
	$("[type='submit']").click(function(){
	var $min=$("[name='min']").val();
	var $max=$("[name='max']").val();
	if(isNaN($min)||isNaN($max)||($min-0)<0||($max-0)<0||($max-$min)<0){
		alert("请输入正确的查询条件");
		return false;
	}
	});
	
	$(".addA").click(function(){
		$.getJSON("${pageContext.request.contextPath}/CartServlet",{"method":"add2Cart","bookId":this.id,"n":Math.random()},function(result){
			$("#totalNum").text(result.totalNum);
			$("#bookName").text(result.bookName);
		});
		//去除a标签默认链接
		return false;
	})
})

</script>
</head>
<body>
<!-- 
	用来从index页面重定向会index获取page对象
 -->
	<%-- <c:if test="${empty requestScope.page }">
		<c:redirect url="BookClientServlet?method=getPageIndex&pageNumber=1"></c:redirect>
	</c:if> --%>
	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">网上书城</span>
		<div>
			<%@ include file="/WEB-INF/include/user_head.jsp" %>
		</div>
	</div>

	<div id="main">
		<div id="book">
		<form action="BookClientServlet">
		<input type="hidden" value="getPageIndexByPrice" name="method">
			<div class="book_cond">
				价格：<input type="text" name="min" value="${param.min }"> 元 - <input type="text"
					name="max" value="${param.max }"> 元
				<input type="submit" value="查询">
			</div>
		</form>
			<div style="text-align: center">
			<c:choose>
				<c:when test="${empty sessionScope.cart.cartItemList }">
					<h3><span id="">抓紧添加您喜欢的商品吧！！！</span></h3>
				</c:when>
				<c:otherwise>
				<span>您的购物车中有<span id="totalNum">${sessionScope.cart.totalBookCount }</span>件商品</span>
				<div>
					您刚刚将<span style="color: red" id="bookName">${sessionScope.title }</span>加入到了购物车中
				</div>
				</c:otherwise>
			</c:choose>
			</div>
			<c:choose>
				<c:when test="${empty requestScope.page.date }">
					<h3>销量太好对不起您来晚了</h3>
				</c:when>
				<c:otherwise>
					<c:forEach items="${requestScope.page.date }" var="book">
						<div class="b_list">
							<div class="img_div">
								<img class="book_img" alt="" src="static/img/default.jpg" />
							</div>
							<div class="book_info">
								<div class="book_name">
									<span class="sp1">书名:</span> <span class="sp2">${book.title }</span>
								</div>
								<div class="book_author">
									<span class="sp1">作者:</span> <span class="sp2">${book.authot }</span>
								</div>
								<div class="book_price">
									<span class="sp1">价格:</span> <span class="sp2">￥${book.price }</span>
								</div>
								<div class="book_sales">
									<span class="sp1">销量:</span> <span class="sp2">${book.sales }</span>
								</div>
								<div class="book_amount">
									<span class="sp1">库存:</span> <span class="sp2">${book.stock }</span>
								</div>
								<div class="book_add">
									<a href="CartServlet?method=add2Cart&bookId=${book.id }" id="${book.id }"  class="addA">加入购物车</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<!-- 引入分页导航栏 -->
		<%@ include file="/WEB-INF/include/nav.jsp"%>
	</div>
	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>
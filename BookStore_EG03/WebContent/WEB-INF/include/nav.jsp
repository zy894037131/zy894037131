<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<div id="page_nav">
			<a href="${requestScope.page.path }&pageNumber=1">首页</a>
			<a
				href="${requestScope.page.path }&pageNumber=${requestScope.page.pageNumer - 1 }">上一页</a>
			
			<!-- 控制分页页码的显示，一页只显示5个页码
				begin和end只能使用变量，动态计算起始和结束索引
			 	1、判断总页码
			 		page.totalPage<=5:  begin=1, end=totalPage
			 		page.totalPage>5: 
			 				如果 page.pageNumber<=3   begin=1,end=5
			 				如果 page.pageNumber>3   begin=pageNumber-2 ,end=pageNumber+2
			 			当页码大于5，设置完end值之后需要判断 end是不是>=总页码  end=totalPage， begin=end-4
			 					
			 -->
			<c:choose>
				<c:when test="${page.totalPage<=5 }">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="${page.totalPage }" ></c:set>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${requestScope.page.pageNumer<=3 }">
							<c:set var="begin" value="1"></c:set>
							<c:set var="end" value="5" ></c:set>
						</c:when>
						<c:otherwise>
							<c:set var="begin" value="${requestScope.page.pageNumer-2 }"></c:set>
							<c:set var="end" value="${requestScope.page.pageNumer+2 }" ></c:set>
							<c:if test="${end>=page.totalPage }">
								<c:set var="begin" value="${page.totalPage-4 }"></c:set>
								<c:set var="end" value="${page.totalPage }" ></c:set>
							</c:if>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
			
			<!-- 遍历展示导航索引 -->
			<!--挑出当前页高亮显示  -->
			<c:forEach begin="${begin }" end="${end }" var="index">
				<c:choose>
					<c:when test="${index==requestScope.page.pageNumer }">
						<span style="color:red">【${index }】</span>
					</c:when>
					<c:otherwise>
						<a href="${requestScope.page.path }&pageNumber=${index }">${index }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<a
				href="${requestScope.page.path }&pageNumber=${requestScope.page.pageNumer + 1 }">下一页</a>
			<a
				href="${requestScope.page.path }&pageNumber=${requestScope.page.totalPage }">末页</a>
			共${requestScope.page.totalPage }页，${ requestScope.page.totalCount}条记录
			到第<input value="${requestScope.page.pageNumer }" name="pn"
				id="pn_input" />页 <input type="button" value="确定" id="btnPage">
			<script type="text/javascript">
				$("#btnPage").click(function(){
					var $page=$("#pn_input").val();
					var $number=/^\d+$/g;
					if($number.test($page)){
						window.location="${requestScope.page.path }&pageNumber="+$page;
					}else{
						alert("这不是一个数字");
						$("#pn_input").val($("#pn_input")[0].defaultValue);
					}
				
				})
				
			</script>
		</div>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%@include file="/pages/common/head.jsp" %>
	<script type="text/javascript">
		//给删除的a标签绑定单击事件，用于删除的确认提示操作
		$(function () {
			$("a.deleteClass").click(function () {
				//在事件的function函数中，有一个this对象。这个this对象，是当前正在响应事件的dom对象
				return confirm("你是否要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
			});
		});
	</script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<%@include file="/pages/common/manager_menu.jsp" %>
	</div>
	
	<div id="main" class="box_no">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>

<%--			<c:forEach items="${requestScope.books}" var="book">--%>
			<c:forEach items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="manager/bookServlet?action=getBookId&id=${book.id}&pageNo=${requestScope.page.pageNo}" class="a_green">修改</a></td>
<%--					<td><a href="manager/bookServlet?action=getBookId&id=${book.id}&method=update" class="a_green">修改</a></td>--%>
<%--					<td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}">删除</a></td>--%>
					<td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
<%--				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>--%>
<%--				<td><a href="pages/manager/book_edit.jsp?method=add">添加图书</a></td>--%>
				<td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>
		</table>

		<%--这里可以用page_nav.jsp静态包含替换掉分页条--%>
		<%@include file="/pages/common/page_nav.jsp"%>
		<%--分页条的开始--%>
<%--		<div id="page_nav">--%>
<%--			&lt;%&ndash;大于首页，才显示:上一页和首页&ndash;%&gt;--%>
<%--			<c:if test="${requestScope.page.pageNo > 1}">--%>
<%--				<a href="${requestScope.page.url}&pageNo=1">首页</a>--%>
<%--				<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">上一页</a>--%>
<%--			</c:if>--%>

<%--			&lt;%&ndash;页码输出的开始&ndash;%&gt;--%>
<%--			<c:choose>--%>
<%--				&lt;%&ndash;情况1：如果总页码小于等于5的情况，页码的范围是：1-总页码&ndash;%&gt;--%>
<%--				<c:when test="${requestScope.page.pageTotal <= 5}">--%>
<%--					<c:set var="begin" value="1"/>--%>
<%--					<c:set var="end" value="${requestScope.page.pageTotal}"/>--%>
<%--				</c:when>--%>
<%--				&lt;%&ndash;情况2：总页码大于5的情况&ndash;%&gt;--%>
<%--				<c:when test="${requestScope.page.pageTotal > 5}">--%>
<%--					<c:choose>--%>
<%--						&lt;%&ndash;小情况1：当前页码为前面3个：1，2，3的情况，页码范围是：1-5.&ndash;%&gt;--%>
<%--						<c:when test="${requestScope.page.pageNo <= 3}">--%>
<%--							<c:set var="begin" value="1"/>--%>
<%--							<c:set var="end" value="5"/>--%>
<%--						</c:when>--%>
<%--						&lt;%&ndash;小情况2：当前页码为最后3个，8，9，10，页码范围是：总页码减4-总页码&ndash;%&gt;--%>
<%--						<c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">--%>
<%--							<c:set var="begin" value="${requestScope.page.pageTotal-4}"/>--%>
<%--							<c:set var="end" value="${requestScope.page.pageTotal}"/>--%>
<%--						</c:when>--%>
<%--						&lt;%&ndash;小情况3：4，5，6，7，页码范围是：当前页码减2-当前页码加2&ndash;%&gt;--%>
<%--						<c:otherwise>--%>
<%--							<c:set var="begin" value="${requestScope.page.pageNo-2}"/>--%>
<%--							<c:set var="end" value="${requestScope.page.pageNo+2}"/>--%>
<%--						</c:otherwise>--%>
<%--					</c:choose>--%>
<%--				</c:when>--%>
<%--			</c:choose>--%>
<%--			<c:forEach begin="${begin}" end="${end}" var="i">--%>
<%--				<c:if test="${i==requestScope.page.pageNo}">--%>
<%--					【${i}】--%>
<%--				</c:if>--%>
<%--				<c:if test="${i != requestScope.page.pageNo}">--%>
<%--					<a href="${requestScope.page.url}&pageNo=${i}">${i}</a>--%>
<%--				</c:if>--%>
<%--			</c:forEach>--%>
<%--			&lt;%&ndash;页码输出的结束&ndash;%&gt;--%>
<%--&lt;%&ndash;			<a href="#">3</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;			【${requestScope.page.pageNo}】&ndash;%&gt;--%>
<%--&lt;%&ndash;			<a href="#">5</a>&ndash;%&gt;--%>


<%--			&lt;%&ndash;如果已经是最后一页，则不显示下一页，末页&ndash;%&gt;--%>
<%--			<c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">--%>
<%--				<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">下一页</a>--%>
<%--				<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>--%>
<%--			</c:if>--%>

<%--			共${requestScope.page.pageTotal}页，${requestScope.page.totalCount}条记录--%>
<%--			到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页--%>
<%--			<input id="searchPageBtn" type="button" value="确定">--%>
<%--			<script type="text/javascript">--%>
<%--				$(function () {--%>
<%--					//跳到指定的页码--%>
<%--					$("#searchPageBtn").click(function () {--%>
<%--						let pageNo = $("#pn_input").val();--%>
<%--						// javaScript语言中提供了一个location地址栏对象--%>
<%--						// 它有一个属性叫href.它可以获取浏览器地址栏中的地址--%>
<%--						// href属性可读，可写--%>
<%--						location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo="+pageNo;--%>
<%--					});--%>
<%--				});--%>
<%--			</script>--%>
<%--		</div>--%>
		<%--分页条的结束--%>
	</div>

	<%@ include file="/pages/common/foot.jsp" %>
</body>
</html>
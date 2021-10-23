<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
	<%@include file="/pages/common/head.jsp"%>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
		<%@include file="/pages/common/manager_menu.jsp" %>
	</div>
	
	<div id="main" class="box_order">
		<table>
			<tr>
				<td>订单号</td>
				<td>订单日期</td>
				<td>订单金额</td>
				<td>订单数量</td>
				<td>订单详情</td>
				<td>发货状态</td>
			</tr>		
			<tr>
				<td>12354456895</td>
				<td>2015.04.23</td>
				<td>90.00</td>
				<td>88</td>
				<td><a href="#">查看详情</a></td>
				<td><a href="#" class="a_green">点击发货</a></td>
			</tr>	
			<tr>
				<td>12354456895</td>
				<td>2015.04.20</td>
				<td>20.00</td>
				<td>88</td>
				<td><a href="#">查看详情</a></td>
				<td>已发货</td>
			</tr>	

		</table>
	</div>

	<%@ include file="/pages/common/foot.jsp" %>
</body>
</html>
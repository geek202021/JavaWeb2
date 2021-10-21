<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
			<div>
				<a href="book_manager.jsp">图书管理</a>
				<a href="order_manager.jsp">订单管理</a>
				<a href="../client/index.jsp">返回商城</a>
			</div>
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
			<tr>
				<td>12354456895</td>
				<td>2014.01.23</td>
				<td>190.00</td>
				<td>88</td>
				<td><a href="#">查看详情</a></td>
				<td>等待收货</td>
			</tr>	
			<tr>
				<td>12354456895</td>
				<td>2014.01.23</td>
				<td>190.00</td>
				<td>88</td>
				<td><a href="#">查看详情</a></td>
				<td>等待收货</td>
			</tr>
			<tr>
				<td>12354456895</td>
				<td>2014.01.23</td>
				<td>190.00</td>
				<td>88</td>
				<td><a href="#">查看详情</a></td>
				<td>等待收货</td>
			</tr>	
		</table>
	</div>

	<%@ include file="/pages/common/foot.jsp" %>
</body>
</html>
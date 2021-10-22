<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
			<%@include file="/pages/common/login_success_munu.jsp"%>
	</div>
	<div id="main" class="box_order">
		<table>
			<tr>
				<td>订单号</td>
				<td>订单日期</td>
				<td>订单金额</td>
				<td>订单数量</td>
				<td>订单状态</td>
				<td>订单详情</td>
			</tr>		
			<tr>
				<td>12354859686</td>
				<td>2015.04.23</td>
				<td>90.00</td>
				<td>88</td>
				<td>未发货</td>
				<td><a href="#">查看详情</a></td>
			</tr>


		</table>
	</div>
	<%@ include file="/pages/common/foot.jsp" %>
</body>
</html>
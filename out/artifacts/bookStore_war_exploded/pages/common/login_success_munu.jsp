<%--
  Created by IntelliJ IDEA.
  User: Jun
  Date: 2021/10/15
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
<%--    <span>欢迎<span class="um_span">张总</span>光临尚硅谷书城</span>--%>
    <%--利用session优化登录和注销--%>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
    <a href="pages/order/order.jsp">我的订单</a>
<%--    <a href="../client/index.jsp">注销</a>&nbsp;&nbsp;--%>
    <a href="userServlet?action=logout">注销</a>
    <a href="../client/index.jsp">返回</a>
</div>

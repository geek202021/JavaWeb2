package com.jun.web;

import com.jun.bean.Cart;
import com.jun.bean.User;
import com.jun.service.OrderService;
import com.jun.service.UserService;
import com.jun.service.impl.OrderServiceImpl;
import com.jun.test.JdbcUtilsTest;
import com.jun.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HuangJun7
 * @date 2021-10-22 18:03
 */
public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //如果用户未登录
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        Integer userId = loginUser.getId();
//        String orderId = null;
//        try {
//            orderId = orderService.createOrder(cart,userId);
//            JdbcUtils.commitAndClose();//提交事务
//        } catch (Exception e) {
//            JdbcUtils.rollbackAndClose();//回滚事务
//            e.printStackTrace();
//        }
        String orderId = orderService.createOrder(cart,userId);
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}

package com.jun.service;

import com.jun.bean.Cart;

/**
 * @author HuangJun7
 * @date 2021-10-22 9:42
 */
public interface OrderService {
    //1.生成订单
    public String createOrder(Cart cart, Integer userId);

    //2.查询全部订单
//    public void showAllOrders();
    //3.发货
//    public void sendOrder(String orderId);
    //4.查看订单详情
    //5.查看我的订单
    //6.签收的订单、确认收货
}

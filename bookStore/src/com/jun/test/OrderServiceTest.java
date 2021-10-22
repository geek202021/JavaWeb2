package com.jun.test;

import com.jun.bean.Cart;
import com.jun.bean.CartItem;
import com.jun.service.OrderService;
import com.jun.service.impl.OrderServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author HuangJun7
 * @date 2021-10-22 18:40
 */
public class OrderServiceTest {
    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"小塔山",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"小塔山",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"小龟山",1,new BigDecimal(50),new BigDecimal(100)));
        OrderService orderService = new OrderServiceImpl();
        System.out.println("订单号是：" + orderService.createOrder(cart,1));
    }
}
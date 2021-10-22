package com.jun.dao;

import com.jun.bean.OrderItem;

/**
 * @author HuangJun7
 * @date 2021-10-22 9:24
 */
public interface OrderItemDao {
    //保存订单项
    public int saveOrderItem(OrderItem orderItem);
}

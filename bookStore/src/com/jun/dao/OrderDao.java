package com.jun.dao;

import com.jun.bean.Order;

/**
 * @author HuangJun7
 * @date 2021-10-22 9:24
 */
public interface OrderDao {
    //保存订单
    public int saveOrder(Order order);
}

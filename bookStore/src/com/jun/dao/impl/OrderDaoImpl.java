package com.jun.dao.impl;

import com.jun.bean.Order;
import com.jun.dao.BaseDao;
import com.jun.dao.OrderDao;

/**
 * @author HuangJun7
 * @date 2021-10-22 9:26
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order2(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}

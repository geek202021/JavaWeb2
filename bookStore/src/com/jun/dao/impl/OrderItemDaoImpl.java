package com.jun.dao.impl;

import com.jun.bean.OrderItem;
import com.jun.dao.BaseDao;
import com.jun.dao.OrderItemDao;

/**
 * @author HuangJun7
 * @date 2021-10-22 9:34
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item2(`order_id`,`name`,`count`,`price`,`total_price`) values(?,?,?,?,?)";
        return update(sql,orderItem.getOrderId(),orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice());
    }
}

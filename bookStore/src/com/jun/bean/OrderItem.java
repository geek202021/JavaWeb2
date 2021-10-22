package com.jun.bean;

import java.math.BigDecimal;

/**
 * @author HuangJun7
 * @date 2021-10-22 9:04
 */
public class OrderItem {
    private Integer id;
    private String orderId;
    private String name;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalPrice;

    public OrderItem() {}

    public OrderItem(Integer id, String orderId, String name, Integer count, BigDecimal price, BigDecimal totalPrice) {
        this.id = id;
        this.orderId = orderId;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

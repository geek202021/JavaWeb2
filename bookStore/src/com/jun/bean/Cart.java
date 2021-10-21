package com.jun.bean;


import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 * @author rujun.huang
 * @date 2021-10-19 21:15
 */
public class Cart{
    //key是商品编号，value是商品信息。使用LinkedHashMap是为了保证购物车中添加图书的顺序。
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public void addItem(CartItem cartItem) {
        //1.要先查看购物车中是否已经添加过此商品，如果已添加，则数额累加，总金额更新
        //2.如果没有添加过(通过对比编号)，直接放到集合中即可
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            //说明之前未添加过此商品：
            items.put(cartItem.getId(), cartItem);
        } else{
            //已经添加过的情况：
            item.setCount(item.getCount()+1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    public void deleteItem(Integer id) {
        items.remove(id);
    }

    public void clear() {
        items.clear();
    }

    public void updateCount(Integer id, Integer count) {
        //查看购物车中是否有此商品，如果有，修改此商品数量，更新总金额。
        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count); //修改商品数量
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
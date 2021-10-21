package com.jun.test;

import com.jun.bean.Cart;
import com.jun.bean.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author rujun.huang
 * @date 2021-10-19 21:41
 */
public class CartTest {
    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"JVM从入门到精通",2,new BigDecimal(50),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"JVM从入门到精通",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"JVM从入门到放弃",1,new BigDecimal(150),new BigDecimal(150)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"JVM从入门到精通",2,new BigDecimal(50),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"JVM从入门到精通",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"JVM从入门到放弃",1,new BigDecimal(150),new BigDecimal(150)));
        cart.deleteItem(2);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"JVM从入门到精通",2,new BigDecimal(50),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"JVM从入门到精通",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"JVM从入门到放弃",1,new BigDecimal(150),new BigDecimal(150)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"JVM从入门到精通",2,new BigDecimal(50),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"JVM从入门到精通",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"JVM从入门到放弃",1,new BigDecimal(150),new BigDecimal(150)));
        cart.clear();
        cart.addItem(new CartItem(2,"JVM从入门到放弃",1,new BigDecimal(150),new BigDecimal(150)));
        cart.updateCount(2,2);
        System.out.println(cart);
    }
}
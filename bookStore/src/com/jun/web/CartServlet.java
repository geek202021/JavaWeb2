package com.jun.web;

import com.jun.bean.Book;
import com.jun.bean.Cart;
import com.jun.bean.CartItem;
import com.jun.service.BookService;
import com.jun.service.impl.BookServiceImpl;
import com.jun.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rujun.huang
 * @date 2021-10-19 22:41
 */
public class CartServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();
    //1.加入购物车
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

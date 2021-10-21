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
        //获取请求的参数，商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService.queryBookById(id):Book 得到图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息，转换成为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用Cart.addItem(CartItem)；添加商品项
        // Cart cart = new Cart(); //采用这种写法会导致totalCount始终为1，因为会创建多个Cart对象
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
//        cart.addItem(cartItem);
        //重定向回商品列表页面
        // resp.sendRedirect(req.getContextPath()); //此种写法有bug,如果点击第二页的“加入购物车“按钮，还是会跳到首页
        resp.sendRedirect(req.getHeader("Referer"));
    }
}

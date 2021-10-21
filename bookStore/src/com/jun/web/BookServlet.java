package com.jun.web;

import com.jun.bean.Book;
import com.jun.bean.Page;
import com.jun.service.BookService;
import com.jun.service.impl.BookServiceImpl;
import com.jun.utils.WebUtils;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author rujun.huang
 * @date 2021-10-16 18:31
 */
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    //1.列出所有图书的信息
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        //把全部图书信息保存到Request域中
        req.setAttribute("books", books);
        //请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    //2.添加图书
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //由于添加一条数据后，有可能页码正好加1,导致不会真正显示最后一条数据所在的页面
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo+=1;
        //1、获取请求的参数==封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.addBook(book);
        //3、跳到图书列表页面
//        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
        //这里不能使用转发操作，会出现bug，要使用重定向。
//        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    //3.删除图书
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数id
//        String id = req.getParameter("id");
//        int i = 0;  //会抛NumberFormatException
//        try {
//            i = Integer.parseInt(id);
//        } catch (NumberFormatException e) {
//            e.printStackTrace();  //在WebUtils中写入改方法。
//        }
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        bookService.deleteBookById(id);
        //3.重定向回图书管理页面
//        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    //4.修改图书功能的实现:第一步：获取要修改的图书id
    protected void getBookId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数的id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.根据id查询图书
        Book book = bookService.queryBookById(id);
        //3.保存到Request域中
        req.setAttribute("book", book);
        //4 请求转发到。pages/manager/book_edit.jsp 页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }
    //5.修改图书功能的实现:第二步：将修改的图书信息保存到数据库
    protected void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数，封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        //3、重定向回图书列表管理页面
//        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }
    //6.处理分页功能
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数pageSize和pageNo
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);

        //（分页条的抽取：2021年10月18日09:49:51）设置后台的url
        page.setUrl("manager/bookServlet?action=page");

        //保存Page对象到Request域中
        req.setAttribute("page", page);
        //4.请求转发到page/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

}

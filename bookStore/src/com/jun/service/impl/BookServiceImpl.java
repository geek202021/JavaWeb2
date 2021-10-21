package com.jun.service.impl;

import com.jun.bean.Book;
import com.jun.bean.Page;
import com.jun.dao.BookDao;
import com.jun.dao.impl.BookDaoImpl;
import com.jun.service.BookService;

import java.util.List;

/**
 * @author rujun.huang
 * @date 2021-10-16 16:35
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer totalCount = bookDao.queryForTotalCount();
        //设置总记录数
        page.setTotalCount(totalCount);
        //求总页码
        Integer pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //设置当前页数据的开始索引:(当前页码数据 - 1) * 每页显示数量
        int begin = (page.getPageNo() -1) * pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);
        //设置当前页数据
        page.setItems(items);
        return page;
    }
    //首页价格区间搜索
    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer totalCount = bookDao.queryForTotalCountByPrice(min,max);
        //设置总记录数
        page.setTotalCount(totalCount);
        //求总页码
        Integer pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //设置当前页数据的开始索引:(当前页码数据 - 1) * 每页显示数量
        int begin = (page.getPageNo() -1) * pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, pageSize,min,max);
        //设置当前页数据
        page.setItems(items);
        return page;
    }
}

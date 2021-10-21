package com.jun.test;

import com.jun.bean.Book;
import com.jun.service.BookService;
import com.jun.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author rujun.huang
 * @date 2021-10-16 16:40
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"MySQL数据库","索尔",new BigDecimal(88),100000,2000,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(6);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(7,"Oracle数据库","麦克",new BigDecimal(200),35000,2000,null));
    }

    @Test
    public void queryBookById() {
        bookService.queryBookById(21);
    }

    @Test
    public void queryBooks() {
        for (Book queryBooks : bookService.queryBooks()) {
            System.out.println(queryBooks);
        }
    }
}
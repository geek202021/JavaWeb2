package com.jun.test;

import com.jun.bean.Book;
import com.jun.dao.BookDao;
import com.jun.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author rujun.huang
 * @date 2021-10-16 14:49
 */
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "Python从入门到精通", "小蜜蜂", new BigDecimal(188), 29999, 2000, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(3);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(4, "火星移民", "索罗斯", new BigDecimal(200), 200000, 10000, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBooks : bookDao.queryBooks()) {
            System.out.println(queryBooks);
        }
    }

    @Test
    public void queryForTotalCount(){
        System.out.println(bookDao.queryForTotalCount());
    }

    @Test
    public void queryForPageItems(){
        for (Book book : bookDao.queryForPageItems(1, 4)){
            System.out.println(book);
        }
    }

    @Test
    public void queryForTotalCountByPrice(){
        System.out.println(bookDao.queryForTotalCountByPrice(10,50));
    }

    @Test
    public void queryForPageItemsByPrice(){
        for (Book book : bookDao.queryForPageItemsByPrice(1, 4,10,50)){
            System.out.println(book);
        }
    }
}
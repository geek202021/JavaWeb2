package com.jun.dao;

import com.jun.bean.Book;

import java.util.List;

/**
 * @author rujun.huang
 * @date 2021-10-16 14:34
 */
public interface BookDao {
    //ctrl + shift + t
    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    //分页的数据总记录数
    Integer queryForTotalCount();

    //当前页数据
    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}

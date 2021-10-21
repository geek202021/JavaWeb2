package com.jun.service;

import com.jun.bean.Book;
import com.jun.bean.Page;

import java.util.List;

/**
 * @author rujun.huang
 * @date 2021-10-16 16:32
 */
public interface BookService {
   void addBook(Book book);

   void deleteBookById(Integer id);

   void updateBook(Book book);
   Book queryBookById(Integer id);

   List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}

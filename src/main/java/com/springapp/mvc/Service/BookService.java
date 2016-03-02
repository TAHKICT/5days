package com.springapp.mvc.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by админ on 29.02.2016.
 */
public interface BookService {

    public String addBook(com.springapp.mvc.Domain.Book book);

    public String addFirstBook(com.springapp.mvc.Domain.Book book);

    public String changeBook (com.springapp.mvc.Domain.Book book);

    public String deleteBook (com.springapp.mvc.Domain.Book book);

    public String deleteBook (Integer bookId);

    public ArrayList<com.springapp.mvc.Domain.Book> getBookList();

    public com.springapp.mvc.Domain.Book getBook(Integer bookId);
}

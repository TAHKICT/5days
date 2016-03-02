package com.springapp.mvc;

import com.springapp.mvc.Domain.Book;
import com.springapp.mvc.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Controller
public class BookController {

    private static boolean isFirstBook = true;

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String startPage(Map<String, Object> map) {
        map.put("bookExisting", !isFirstBook);
        return "startPage";
    }

    @RequestMapping("/books")
    public String bookList(Map<String, Object> map) {

        map.put("bookList", bookService.getBookList());
        map.put("book", new Book());

        return "bookList";
    }

    @RequestMapping("/book/{bookId}")
    public String bookEdit(@PathVariable("bookId") Integer bookId,
                           Map<String, Object> map) {

        map.put("book", bookService.getBook(bookId));

        return "bookEdit";
    }

    @RequestMapping(value = "/changeBook", method = RequestMethod.POST)
    public String changeBook(@ModelAttribute("book") Book book,
                                   Map<String, Object> map) throws UnsupportedEncodingException {

        String action = bookService.changeBook(book);

        if(action.equals("ok")) {
            return "redirect:/books";
        }else{
            map.put("errorString",action);
            return "universalError";
        }
    }

    @RequestMapping("/book/new")
    public String bookAdd(Map<String, Object> map) {

        map.put("book", new Book());

        return "bookAdd";
    }

    @RequestMapping(value = "/book/addBook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book,
                                   Map<String, Object> map){
        String action;
        if(isFirstBook){
            action = bookService.addFirstBook(book);
            isFirstBook = false;
        }
        else
            action = bookService.addBook(book);

        if(action.equals("ok")) {
            return "redirect:/books";
        }else{
            map.put("errorString",action);
            return "universalError";
        }
    }

    @RequestMapping("/book/remove/{bookId}")
    public String bookRemove(@PathVariable("bookId") Integer bookId,
                           Map<String, Object> map) {

        if(bookService.getBookList().size() == 1)
            isFirstBook = true;

        String action = bookService.deleteBook(bookId);

        if(action.equals("ok")) {
            return "redirect:/books";
        }else{
            map.put("errorString",action);
            return "universalError";
        }

    }

}

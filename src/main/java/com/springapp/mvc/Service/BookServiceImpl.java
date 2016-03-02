package com.springapp.mvc.Service;

import com.springapp.mvc.Domain.Book;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.extended.EncodedByteArrayConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    String xmlName = "books";

    @Override
    public String addBook(com.springapp.mvc.Domain.Book book) {
        List<com.springapp.mvc.Domain.Book> bookList = getBookList();
        if(bookList == null || bookList.size() == 0)
            book.setId(0);
        else
            book.setId(getLastId(bookList) + 1);

        bookList.add(book);

        try {
            marshaller(bookList, xmlName);
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "could not add the book";
        }
    }

    @Override
    public String addFirstBook(Book book) {
        List<com.springapp.mvc.Domain.Book> bookList = new ArrayList<Book>();

        book.setId(0);
        bookList.add(book);

        try {
            marshaller(bookList, xmlName);
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "could not add the book";
        }
    }

    @Override
    public String changeBook(com.springapp.mvc.Domain.Book book) {
        if(!getBookList().isEmpty()) {
            List<Book> list = getBookList();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == book.getId()) {
                    list.get(i).setAuthor(book.getAuthor());
                    list.get(i).setDescription(book.getDescription());
                    list.get(i).setGenre(book.getGenre());
                    list.get(i).setPrice(book.getPrice());
                    list.get(i).setPublishDate(book.getPublishDate());
                    list.get(i).setTitle(book.getTitle());
                    break;
                }
            }
            try {
                marshaller(list, xmlName);
                return "ok";
            } catch (IOException e) {
                e.printStackTrace();
                return "could not change the book";
            }
        }else
            return "there are no books in base";
    }

    @Override
    public String deleteBook(com.springapp.mvc.Domain.Book book) {
        if(!getBookList().isEmpty()) {
            List<Book> bookList = getBookList();
            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).getId() == book.getId())
                    bookList.remove(i);
            }

            try {
                marshaller(bookList, xmlName);
                return "ok";
            } catch (IOException e) {
                e.printStackTrace();
                return "could not remove the book";
            }
        }else
            return "there are no books in base";
    }

    @Override
    public String deleteBook(Integer bookId) {
        return deleteBook(getBook(bookId));
    }

    @Override
    public ArrayList<com.springapp.mvc.Domain.Book> getBookList() {
        try {
            return unmarshalling(new File("C:\\"+xmlName.concat(".xml")));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Book getBook(Integer bookId) {
        Book book = null;
        if(getBookList() != null)
            if (!getBookList().isEmpty())
                for (int i = 0; i < getBookList().size(); i++) {
                    if (getBookList().get(i).getId() == bookId) {
                        book =  getBookList().get(i);
                        break;
                    }
                }
        return book;
    }

    private static void marshaller(List<com.springapp.mvc.Domain.Book> object, String nameXmlFile) throws IOException {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias(nameXmlFile, List.class);
        xStream.processAnnotations(com.springapp.mvc.Domain.Book.class);

        String xml = xStream.toXML(object);
        saveToFile(xml, nameXmlFile);
    }

    private static void saveToFile(String xml, String nameFile) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:\\"+nameFile+".xml")));
        bufferedWriter.write(xml);
        bufferedWriter.close();
    }

    private static ArrayList<com.springapp.mvc.Domain.Book> unmarshalling(File file) throws IOException, ClassNotFoundException {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("books", List.class);
        xStream.alias("book", com.springapp.mvc.Domain.Book.class);
        xStream.aliasField("author", com.springapp.mvc.Domain.Book.class, "author");
        xStream.aliasField("title", com.springapp.mvc.Domain.Book.class, "title");
        xStream.aliasField("genre", com.springapp.mvc.Domain.Book.class, "genre");
        xStream.aliasField("price", com.springapp.mvc.Domain.Book.class, "price");
        xStream.aliasField("publish_date", com.springapp.mvc.Domain.Book.class, "publishDate");
        xStream.aliasField("description", com.springapp.mvc.Domain.Book.class, "description");

        xStream.aliasAttribute(com.springapp.mvc.Domain.Book.class, "id", "id");
        xStream.registerConverter((Converter) new EncodedByteArrayConverter());

        return (ArrayList<com.springapp.mvc.Domain.Book>) xStream.fromXML(file);
    }

    private Integer getLastId(List<com.springapp.mvc.Domain.Book> bookList){
        if(bookList != null && bookList.size() != 0) {
            int id = bookList.get(0).getId();
            if(bookList.size() > 1)
                for (int i = 1; i < bookList.size(); i++) {
                    if (bookList.get(i).getId() > id)
                        id = bookList.get(i).getId();
                }
            return id;
        }else
            return null;
    }
}

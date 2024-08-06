package ait.book_library.dao;

import ait.book_library.model.Book;

public interface Library {
    //add a book to library
    boolean addBook(Book book);

    //remove book from library
    Book removeBook(long isbn);

    //find a book in library
    Book findBook(long isbn);

    //count books in library
    int quantity();

    //print out all books in library
    void printBooks();

}

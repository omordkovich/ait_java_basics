package ait.book_library.test;

import ait.book_library.dao.Library;
import ait.book_library.dao.LibraryImpl;
import ait.book_library.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LibraryImplTest {
    Library library;
    Book[] books;

    @BeforeEach
    void setUp() {
        library = new LibraryImpl(5);
        books = new Book[5];
        books[0] = new Book("Title 1", "Author 1", 2002, 1_111_111_111_112L);
        books[1] = new Book("Title 2", "Author 2", 1985, 1_111_111_111_113L);
        books[2] = new Book("Title 3", "Author 1", 1999, 1_111_111_111_114L);
        books[3] = new Book("Title 4", "Author 4", 2016, 1_111_111_111_115L);

        for (int i = 0; i < books.length; i++) {
            library.addBook(books[i]);
        }
    }

    @Test
    void addBook() {
        assertFalse(library.addBook(null));
        assertFalse(library.addBook(books[0]));
        Book myBook = new Book("Titel 5", "Author 5",1998,1_111_111_111_116L);
        assertTrue(library.addBook(myBook));
        assertEquals(5,library.quantity());
        myBook = new Book("Titel 6", "Author 6",2006,1_111_111_111_117L);
        assertFalse(library.addBook(myBook));
    }

    @Test
    void removeBook() {
        Book victim = library.removeBook(1_111_111_111_113L);
        assertEquals(books[1],victim);
        assertEquals(3,library.quantity());
        assertNull(library.removeBook(1_111_111_111_113L));
    }

    @Test
    void findBook() {
        assertEquals(books[1],library.findBook(1_111_111_111_113L));
        assertNull(library.findBook(2_111_111_111_113L));
    }

    @Test
    void quantity() {
        assertEquals(4,library.quantity());
    }

    @Test
    void printBooks() {
        library.printBooks();
    }

    @Test
    void ofAuthor(){
    Book[] expected = {books[0],books[2]};
    Book[] actual = library.ofAuthor("Author 1");
    assertArrayEquals(expected,actual);
    }

    @Test
    void findByYear(){
        Book[] expected = {books[1],books[2]};
        Book[] actual = library.findByYear(1980,2000);
        assertArrayEquals(expected,actual);
    }
}
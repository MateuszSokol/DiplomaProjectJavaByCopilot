package library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
        library.addBook(new Book("111", "Wiedźmin", "Sapkowski"));
        library.addBook(new Book("222", "Hobbit", "Tolkien"));
        library.addBook(new Book("333", "Dune", "Herbert"));
    }

    // -----------------------------
    // addBook
    // -----------------------------
    @Test
    void testAddBook() {
        Book newBook = new Book("444", "Metro 2033", "Glukhovsky");
        library.addBook(newBook);

        assertEquals(4, library.getBooks().size());
        assertTrue(library.getBooks().contains(newBook));
    }

    // -----------------------------
    // removeBook
    // -----------------------------
    @Test
    void testRemoveBookSuccess() {
        boolean removed = library.removeBook("111");

        assertTrue(removed);
        assertEquals(2, library.getBooks().size());
        assertNull(library.findByTitle("Wiedźmin"));
    }

    @Test
    void testRemoveBookFail() {
        boolean removed = library.removeBook("999");

        assertFalse(removed);
        assertEquals(3, library.getBooks().size());
    }

    // -----------------------------
    // findByTitle
    // -----------------------------
    @Test
    void testFindByTitleSuccess() {
        Book found = library.findByTitle("Hobbit");

        assertNotNull(found);
        assertEquals("222", found.getIsbn());
    }

    @Test
    void testFindByTitleIgnoreCase() {
        Book found = library.findByTitle("dUnE");

        assertNotNull(found);
        assertEquals("333", found.getIsbn());
    }

    @Test
    void testFindByTitleNotFound() {
        Book found = library.findByTitle("Nieistniejąca książka");

        assertNull(found);
    }

    // -----------------------------
    // getBooks
    // -----------------------------
    @Test
    void testGetBooksReturnsList() {
        List<Book> books = library.getBooks();

        assertEquals(3, books.size());
        assertEquals("Wiedźmin", books.get(0).getTitle());
    }
}

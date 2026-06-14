package library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testBookConstructorAndGetters() {
        Book book = new Book("123", "Wiedźmin", "Sapkowski");

        assertEquals("123", book.getIsbn());
        assertEquals("Wiedźmin", book.getTitle());
        assertEquals("Sapkowski", book.getAuthor());
    }

    @Test
    void testToString() {
        Book book = new Book("123", "Wiedźmin", "Sapkowski");

        String result = book.toString();

        assertTrue(result.contains("123"));
        assertTrue(result.contains("Wiedźmin"));
        assertTrue(result.contains("Sapkowski"));
    }
}

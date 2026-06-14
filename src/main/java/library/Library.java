package library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {

    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Dodano książkę: " + book.getTitle());
    }

    public boolean removeBook(String isbn) {
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
                System.out.println("Usunięto książkę o ISBN: " + isbn);
                return true;
            }
        }

        System.out.println("Nie znaleziono książki o ISBN: " + isbn);
        return false;
    }

    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getBooks() {
        return books;
    }
}

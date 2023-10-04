package aop;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class UniLibrary {

    private final Map<String, Book> books;

    public UniLibrary(Book... books) {
        this.books = new HashMap<>();
        for(Book book : books) {
            this.addBook(book);
        }
    }

    public Book getBook(String title) throws Exception {
        if (!books.containsKey(title)) {
            throw new Exception("Книги с таким названием нет в библиотеке");
        }
        return books.get(title);
    }

    public void addBook(Book book) {
        books.put(book.title(), book);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Библиотека:\n");
        for (Book book : books.values()) {
            result.append("\t")
                    .append(book.idHuman())
                    .append(" -> ")
                    .append(book.title())
                    .append("\n");
        }
        return result.toString();
    }
}

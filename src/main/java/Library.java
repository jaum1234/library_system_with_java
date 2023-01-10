import java.util.ArrayList;
import java.util.Date;

public class Library
{
    private ArrayList<Book> books;

    public Library()
    {
        this.books = new ArrayList<>();
    }

    public void registerBook(
            String title,
            String author,
            String publisher,
            Date publishDate
    ) throws Exception
    {
        if (this.containsBook(title, author)) {
            throw new Exception("Book already registed.");
        }

        Book book = new Book(title, author, publisher, publishDate);

        this.books.add(book);
    }

    public void removeBook(String title, String author) throws Exception
    {
        Book book = this.findBook(title, author);

        if (book == null) {
            throw new Exception("Book not found");
        }

        this.books.remove(book);
    }

    public boolean containsBook(String title, String author)
    {
        for (Book registedBook : this.books) {
            if (registedBook.title().equals(title) && registedBook.author().equals(author)) return true;
        }

        return false;
    }

    public Book findBook(String title, String author)
    {
        for (Book registedBook : this.books) {
            if (registedBook.author().equals(author) && registedBook.title().equals(title)) return registedBook;
        }

        return null;
    }


}
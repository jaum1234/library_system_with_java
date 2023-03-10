import exceptions.DuplicatedEntryException;
import exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.Date;

public class Library
{
    private ArrayList<Book> books;
    private ArrayList<Client> clients;

    public Library()
    {
        this.books = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public void registerBook(
            String title,
            String author,
            String publisher,
            Date publishDate
    ) throws Exception
    {
        if (this.containsBook(title, author)) {
            throw new DuplicatedEntryException("Book already registed.");
        }


        Book book = new Book(title, author, publisher, publishDate);

        this.books.add(book);
    }

    public void removeBook(String title, String author) throws Exception
    {
        Book book = this.findBook(title, author);

        if (book == null) {
            throw new EntityNotFoundException("Book not found");
        }

        this.books.remove(book);
    }

    // Time complexity: O(n)
    public boolean containsBook(String title, String author)
    {
        for (Book registedBook : this.books) {
            if (registedBook.title().equals(title) && registedBook.author().equals(author)) return true;
        }

        return false;
    }

    // Time complexity: O(n)
    public Book findBook(String title, String author)
    {
        for (Book registedBook : this.books) {
            if (registedBook.author().equals(author) && registedBook.title().equals(title)) return registedBook;
        }

        return null;
    }

    // Time complexity: O(n)
    public void registerClient(String cpf, String name) throws Exception
    {
        if (this.containsClient(cpf)) {
            throw new DuplicatedEntryException("Client already registered");
        }

        Client client = new Client(cpf, name);

        this.clients.add(client);
    }

    public boolean containsClient(String cpf)
    {
        for (Client client : this.clients) {
            if (client.cpf().equals(cpf)) return true;
        }

        return false;
    }
}

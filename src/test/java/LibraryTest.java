import exceptions.DuplicatedEntryException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest
{
    private Library library;

    @BeforeEach()
    void setUp()
    {
        this.library = new Library();
    }

    @Test
    @DisplayName("Should register a new book.")
    void shouldRegisterANewBook() throws Exception
    {
        String bookName = "book name";
        String bookAuthor = "book author";
        String bookPublisher = "book publisher";
        Date bookPublishData = new Date();

        this.library.registerBook(bookName, bookAuthor, bookPublisher, bookPublishData);

        assertTrue(this.library.containsBook(bookName, bookAuthor));
    }

    @Test
    @DisplayName("Should not register duplicated books.")
    void shouldNotRegisterDuplicatedBooks() throws Exception
    {
        String book1Name = "book name";
        String book1Author = "book author";
        String book1Publisher = "book publisher";
        Date book1PublishData = new Date();

        String book2Name = "book name";
        String book2Author = "book author";
        String book2Publisher = "book publisher";
        Date book2PublishData = new Date();

        assertDoesNotThrow(() ->
            this.library.registerBook(book1Name, book1Author, book1Publisher, book1PublishData)
        );

        assertThrows(DuplicatedEntryException.class, () ->
            this.library.registerBook(book2Name, book2Author, book2Publisher, book2PublishData)
        );
    }

    @Test
    @DisplayName("Should remove a book.")
    void shouldRemoveABook() throws Exception
    {
        String book1Name = "book name";
        String book1Author = "book author";
        String book1Publisher = "book publisher";
        Date book1PublishData = new Date();

        this.library.registerBook(book1Name, book1Author, book1Publisher, book1PublishData);

        assertDoesNotThrow(() ->
            this.library.removeBook(book1Name, book1Author)
        );

        assertFalse(this.library.containsBook(book1Name, book1Author));
    }

    @Test
    @DisplayName("Should not remove book if it does not exists.")
    void shouldNotRemoveBookIfItDoesNotExists() throws Exception
    {
        String book1Name = "book name";
        String book1Author = "book author";

        assertThrows(Exception.class, () ->
            this.library.removeBook(book1Name, book1Author)
        );
    }

    @Test
    @DisplayName("Shoud register a new client")
    void shouldRegisterANewClient() throws Exception
    {
        String cpf = "11111111111";
        String name = "client name";

        assertDoesNotThrow(() ->
            this.library.registerClient(cpf, name)
        );

        assertTrue(this.library.containsClient(cpf));
    }

    @Test
    @DisplayName("Shoud not register duplicated clients")
    void shouldNotRegisterDuplicatedClients() throws Exception
    {
        String cpf1 = "11111111111";
        String name1 = "client name";

        String cpf2 = "11111111111";
        String name2 = "another client name";

        assertDoesNotThrow(() ->
            this.library.registerClient(cpf1, name1)
        );

        assertThrows(DuplicatedEntryException.class, () ->
            this.library.registerClient(cpf2, name2)
        );
    }
}

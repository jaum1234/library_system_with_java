import java.util.Date;

public class Book
{
    private String title;
    private String author;
    private String publisher;
    private Date publishDate;

    public Book(String title, String author, String publisher, Date publishDate)
    {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
    }

    public String title()
    {
        return this.title;
    }

    public String author()
    {
        return this.author;
    }

    public String publisher()
    {
        return this.publisher;
    }

    public Date publishData()
    {
        return this.publishDate;
    }

    public boolean equals(Book book)
    {
        return this.author.equals(book.author) && this.title.equals(book.title);
    }
}

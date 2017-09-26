package is.ru.honn.model;

import java.util.Date;

public class Book
{
    private int id;
    private String title;
    private String firstName;
    private String lastName;
    private Date datePublished;
    private String isbn;

    public Book(int id, String title, String firstName, String lastName, Date datePublished, String isbn)
    {
        this.id = id;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.datePublished = datePublished;
        this.isbn = isbn;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Date getDatePublished()
    {
        return datePublished;
    }

    public void setDatePublished(Date datePublished)
    {
        this.datePublished = datePublished;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }
}

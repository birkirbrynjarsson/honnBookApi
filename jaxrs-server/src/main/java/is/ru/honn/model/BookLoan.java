package is.ru.honn.model;

import java.util.Date;

public class BookLoan
{
    private int userId;
    private int bookId;
    private Date dateLoaned;
    private Date dateReturned;

    public BookLoan(int userId, int bookId, Date dateLoaned, Date dateReturned)
    {
        this.userId = userId;
        this.bookId = bookId;
        this.dateLoaned = dateLoaned;
        this.dateReturned = dateReturned;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public int getBookId()
    {
        return bookId;
    }

    public void setBookId(int bookId)
    {
        this.bookId = bookId;
    }

    public Date getDateLoaned()
    {
        return dateLoaned;
    }

    public void setDateLoaned(Date dateLoaned)
    {
        this.dateLoaned = dateLoaned;
    }

    public Date getDateReturned()
    {
        return dateReturned;
    }

    public void setDateReturned(Date dateReturned)
    {
        this.dateReturned = dateReturned;
    }
}

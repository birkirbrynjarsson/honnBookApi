package is.ru.honn.service;

import io.swagger.model.*;
import is.ru.honn.model.BookLoan;

import java.util.Date;
import java.util.List;

public interface BookService
{
    void setUserService(UserService userService);

    List<BookLoan> getBookLoans();

    void addBook(AddBookViewModel book);
    void updateBook(int bookId, AddBookViewModel book);
    void deleteBook(int bookId);
    BookViewModel getBookById(int id);
    List<BookViewModel> getAllBooks();
    List<BookViewModel> getBooksByRating();

    List<BookLoanViewModel> getBookLoanHistory(int bookId);
    List<BookReviewViewModel> getBookReviewsByBookId(int bookId);
    List<BookAndUserLoanViewModel> getLoanedBooksByDate(Date date);
    List<BookReviewViewModel> getBookReviewByUserId(int userId);

    void addReview(int bookId, int userId, AddBookReviewViewModel bookReview);
    void deleteBookReview(int bookId, int userId);

    void loanBook(int bookId, int userId);
    void returnBook(int bookId);
    void updateBookLoan(int bookId, int userId, UpdateBookLoanViewModel bookLoan);
    void deleteLoan(int bookId, int userId);
}
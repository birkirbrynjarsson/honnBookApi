package is.ru.honn.service;

import io.swagger.model.AddBookReviewViewModel;
import io.swagger.model.AddBookViewModel;
import io.swagger.model.BookViewModel;

import java.util.List;

public interface BookService
{
    void setBookService(BookService bookService);
    List<BookViewModel> getAllBooks();
    void addBook(AddBookViewModel book);
    BookViewModel getBookById(int id);
    void addReview(int bookId, int userId, AddBookReviewViewModel bookReview);
}
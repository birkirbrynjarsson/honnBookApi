package is.ru.honn.service;

import io.swagger.model.*;
import is.ru.honn.model.Book;
import is.ru.honn.model.BookLoan;
import is.ru.honn.model.BookReview;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class MemoryBookService implements BookService
{
    private static UserService userService;
    private static ArrayList<Book> books = new ArrayList<Book>();
    private static ArrayList<BookLoan> bookLoans = new ArrayList<BookLoan>();
    private static ArrayList<BookReview> bookReviews = new ArrayList<BookReview>();

    public MemoryBookService(){
        if(books.isEmpty()){
            String fileBooks = System.getProperty("user.dir") + "/json/books.json";
            JSONParser jsonParser = new JSONParser();
            List<JSONObject> jsonBooks = new ArrayList<JSONObject>();
            try {
                JSONArray objArray = (JSONArray) jsonParser.parse(new FileReader(fileBooks));
                for(Object book : objArray){
                    jsonBooks.add((JSONObject) book);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            for(JSONObject jsonBook : jsonBooks){
                int bookId = ((Long)jsonBook.get("bookid")).intValue();
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date datePublished = null;
                try {
                    datePublished = formatter.parse((String)jsonBook.get("datepublished"));
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                }
                Book book = new Book(
                        bookId,
                        (String)jsonBook.get("title"),
                        (String)jsonBook.get("firstname"),
                        (String)jsonBook.get("lastname"),
                        datePublished,
                        (String)jsonBook.get("isbn")
                );
                this.books.add(book);
            }
        }
        if(bookLoans.isEmpty()){
            String fileUsers = System.getProperty("user.dir") + "/json/users.json";
            JSONParser jsonParser = new JSONParser();
            List<JSONObject> jsonUsers = new ArrayList<JSONObject>();
            try {
                JSONArray objArray = (JSONArray) jsonParser.parse(new FileReader(fileUsers));
                for(Object book : objArray){
                    jsonUsers.add((JSONObject) book);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            for(JSONObject user : jsonUsers){
                if(user.get("booksborrowed") != null){
                    JSONArray jsonLoan = (JSONArray) user.get("booksborrowed");
                    for(Object objLoan : jsonLoan){
                        JSONObject loan = (JSONObject) objLoan;
                        int userId = ((Long)user.get("userid")).intValue();
                        int bookId = ((Long)loan.get("bookid")).intValue();
                        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date dateLoaned = null;
                        try {
                            dateLoaned = formatter.parse((String)loan.get("dateborrowed"));
                        } catch (java.text.ParseException e) {
                            e.printStackTrace();
                        }
                        BookLoan bookLoan = new BookLoan(userId, bookId, dateLoaned, null);
                        bookLoans.add(bookLoan);
                    }
                }
            }
        }
    }

    private int newId(){
        int maxId = 0;
        for (int i = 0; i < books.size(); i++){
            maxId = books.get(i).getId() > maxId ? books.get(i).getId() : maxId;
        }
        return maxId + 1;
    }

    @Override
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    @Override
    public List<BookLoan> getBookLoans()
    {
        return bookLoans;
    }

    @Override
    public void addBook(AddBookViewModel book)
    {
        Book newBook = new Book(newId(), book.getTitle(), book.getFirstName(), book.getLastName(), book.getDatePublished(), book.getIsbn());
        books.add(newBook);
    }

    @Override
    public void updateBook(int bookId, AddBookViewModel book)
    {
        int index = 0;
        boolean bookFound = false;
        for(; index < books.size(); index++){
            if(books.get(index).getId() == bookId){
                bookFound = true;
                break;
            }
        }
        if(bookFound){
            books.get(index).setTitle(book.getTitle());
            books.get(index).setFirstName(book.getFirstName());
            books.get(index).setLastName(book.getLastName());
            books.get(index).setDatePublished(book.getDatePublished());
            books.get(index).setIsbn(book.getIsbn());
        }
    }

    @Override
    public void deleteBook(int bookId)
    {
        int index = 0;
        boolean bookFound = false;
        for(; index < books.size(); index++){
            if(books.get(index).getId() == bookId){
                bookFound = true;
                break;
            }
        }
        if(bookFound){
            books.remove(index);
        }
    }

    @Override
    public BookViewModel getBookById(int id)
    {
        int index = 0;
        boolean bookFound = false;
        for(; index < books.size(); index++){
            if(books.get(index).getId() == id){
                bookFound = true;
                break;
            }
        }
        if(bookFound){
            BookViewModel returnedBook = new BookViewModel();
            returnedBook.id(books.get(index).getId());
            returnedBook.title(books.get(index).getTitle());
            returnedBook.firstName(books.get(index).getFirstName());
            returnedBook.lastName(books.get(index).getLastName());
            returnedBook.datePublished(books.get(index).getDatePublished());
            returnedBook.isbn(books.get(index).getIsbn());
            return returnedBook;
        }
        return null;
    }

    @Override
    public List<BookViewModel> getAllBooks()
    {
        List<BookViewModel> returnedBooks = new ArrayList<BookViewModel>();
        for(int i = 0; i < books.size(); i++){
            BookViewModel book = new BookViewModel();
            book.id(books.get(i).getId());
            book.title(books.get(i).getTitle());
            book.firstName(books.get(i).getFirstName());
            book.lastName(books.get(i).getLastName());
            book.datePublished(books.get(i).getDatePublished());
            book.isbn(books.get(i).getIsbn());
            returnedBooks.add(book);
        }
        return returnedBooks;
    }

    @Override
    public List<BookViewModel> getBooksByRating() { return null; }

    @Override
    public List<BookLoanViewModel> getBookLoanHistory(int bookId)
    {
        List<BookLoanViewModel> bookList = new ArrayList<BookLoanViewModel>();
        for(int i = 0; i < bookLoans.size(); i++){
            if(bookLoans.get(i).getBookId() == bookId){
                BookLoanViewModel book = new BookLoanViewModel();
                book.setUser(userService.getUserById(bookLoans.get(i).getUserId()));
                book.setDateLoaned(bookLoans.get(i).getDateLoaned());
                book.setDateReturned(bookLoans.get(i).getDateReturned());
                bookList.add(book);
            }
        }
        return bookList;
    }

    @Override
    public List<BookReviewViewModel> getBookReviewsByBookId(int bookId)
    {
        List<BookReviewViewModel> books = new ArrayList<BookReviewViewModel>();
        for(int i = 0; i < bookReviews.size(); i++){
            if(bookReviews.get(i).getBookId() == bookId){
                BookReviewViewModel review = new BookReviewViewModel();
                review.setUser(userService.getUserById(bookReviews.get(i).getUserId()));
                review.setRating(bookReviews.get(i).getRating());
                review.setReview(bookReviews.get(i).getReview());
                books.add(review);
            }
        }
        return books;
    }

    @Override
    public List<BookAndUserLoanViewModel> getLoanedBooksByDate(Date date)
    {
        List<BookAndUserLoanViewModel> models = new ArrayList<BookAndUserLoanViewModel>();
        for(int i = 0; i < bookLoans.size(); i++){
            if(bookLoans.get(i).getDateLoaned().before(date) && (bookLoans.get(i).getDateReturned() == null || bookLoans.get(i).getDateReturned().after(date))){
                BookAndUserLoanViewModel model = new BookAndUserLoanViewModel();
                model.setBook(getBookById(bookLoans.get(i).getBookId()));
                model.setUser(userService.getUserById(bookLoans.get(i).getUserId()));
                model.setDateLoaned(bookLoans.get(i).getDateLoaned());
                models.add(model);
            }
        }
        return models;
    }

    @Override
    public List<BookReviewViewModel> getBookReviewByUserId(int userId)
    {
        List<BookReviewViewModel> models = new ArrayList<BookReviewViewModel>();
        for(int i = 0; i < bookReviews.size(); i++){
            if(bookReviews.get(i).getUserId() == userId){
                BookReviewViewModel model = new BookReviewViewModel();
                model.setUser(userService.getUserById(userId));
                model.setReview(bookReviews.get(i).getReview());
                model.setRating(bookReviews.get(i).getRating());
                models.add(model);
            }
        }
        return models;
    }

    @Override
    public void addReview(int bookId, int userId, AddBookReviewViewModel bookReview)
    {
        if(userService.getUserById(userId) == null){
            return;
        }
        if(getBookById(bookId) == null){
            return;
        }
        boolean reviewExists = false;
        for(int i = 0; i < bookReviews.size(); i++){
            if(bookReviews.get(i).getBookId() == bookId && bookReviews.get(i).getUserId() == userId){
                reviewExists = true;
                bookReviews.get(i).setRating(bookReview.getRating());
                bookReviews.get(i).setReview(bookReview.getReview());
                break;
            }
        }
        if(!reviewExists){
            BookReview newReview = new BookReview(bookId, userId, bookReview.getRating(), bookReview.getReview());
            bookReviews.add(newReview);
        }
    }

    @Override
    public void deleteBookReview(int bookId, int userId)
    {
        boolean reviewExists = false;
        int index = 0;
        for(; index < bookReviews.size(); index++){
            if(bookReviews.get(index).getBookId() == bookId && bookReviews.get(index).getUserId() == userId){
                reviewExists = true;
                break;
            }
        }
        if(reviewExists){
            bookReviews.remove(index);
        }
    }

    @Override
    public void loanBook(int bookId, int userId)
    {
        if(userService.getUserById(userId) == null){
            return;
        }
        if(getBookById(bookId) == null){
            return;
        }
        boolean bookReturned = true;
        for(int i = 0; i < bookLoans.size(); i++){
            if(bookLoans.get(i).getBookId() == bookId){
                if(bookLoans.get(i).getDateReturned() == null){
                    bookReturned = false;
                    break;
                }
            }
        }
        if(bookReturned){
            BookLoan bookLoan = new BookLoan(userId, bookId, new Date(), null);
        }
    }

    @Override
    public void returnBook(int bookId)
    {
        for(int i = 0; i < bookLoans.size(); i++){
            if(bookLoans.get(i).getBookId() == bookId){
                if(bookLoans.get(i).getDateReturned() == null){
                    bookLoans.get(i).setDateReturned(new Date());
                    break;
                }
            }
        }
    }

    @Override
    public void updateBookLoan(int bookId, int userId, UpdateBookLoanViewModel bookLoan)
    {
        for(int i = 0; i < bookLoans.size(); i++){
            if(bookLoans.get(i).getBookId() == bookId && bookLoans.get(i).getUserId() == userId){
                bookLoans.get(i).setDateLoaned(bookLoan.getDateLoaned());
                bookLoans.get(i).setDateReturned(bookLoan.getDateReturned());
                break;
            }
        }
    }

    // This doesn't make sure that the same user hasn't loaned the book multiple times
    @Override
    public void deleteLoan(int bookId, int userId)
    {
        boolean loanFound = false;
        int index = 0;
        for(; index < bookLoans.size(); index++){
            if(bookLoans.get(index).getBookId() == bookId && bookLoans.get(index).getUserId() == userId){
                loanFound = true;
                break;
            }
        }
        if(loanFound){
            bookLoans.remove(index);
        }
    }
}

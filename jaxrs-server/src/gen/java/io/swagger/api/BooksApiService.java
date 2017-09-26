package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import java.math.BigDecimal;
import io.swagger.model.Book;
import io.swagger.model.BookCurrentUser;
import io.swagger.model.BookLoan;
import io.swagger.model.BookLoanWithUser;
import io.swagger.model.BookReview;
import java.util.Date;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-25T22:03:01.666Z")
public abstract class BooksApiService {
    public abstract Response addBook(Book body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addReview(Long bookId,Long userId,BookReview body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteBook(Long bookId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteBookReview(Long bookId,Long userId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteLoan(Long bookId,Long userId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAllBooks(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getBookById(Long bookId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getBookLoanHistory(Long bookId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getBookReviewsByBookId(BigDecimal bookId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getBooksByRating(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getLoanedBooksByDate(Date date,SecurityContext securityContext) throws NotFoundException;
    public abstract Response loanBook(Long bookId,Long userId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response returnBook(Long bookId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateBook(Long bookId,Book body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateBookLoan(Long bookId,Long userId,BookLoan body,SecurityContext securityContext) throws NotFoundException;
}

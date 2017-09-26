package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.AddBookReviewViewModel;
import io.swagger.model.AddBookViewModel;
import java.math.BigDecimal;
import io.swagger.model.BookAndUserLoanViewModel;
import io.swagger.model.BookLoanViewModel;
import io.swagger.model.BookReviewViewModel;
import io.swagger.model.BookViewModel;
import java.util.Date;
import io.swagger.model.UpdateBookLoanViewModel;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-26T11:45:59.080Z")
public abstract class BooksApiService {
    public abstract Response addBook(AddBookViewModel body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addReview(Long bookId,Long userId,AddBookReviewViewModel body,SecurityContext securityContext) throws NotFoundException;
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
    public abstract Response updateBook(Long bookId,AddBookViewModel body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateBookLoan(Long bookId,Long userId,UpdateBookLoanViewModel body,SecurityContext securityContext) throws NotFoundException;
}

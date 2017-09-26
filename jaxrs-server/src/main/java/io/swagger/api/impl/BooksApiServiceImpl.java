package io.swagger.api.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.swagger.api.*;
import io.swagger.model.*;

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

import is.ru.honn.service.BookService;
import is.ru.honn.service.UserService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.swing.text.html.parser.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-26T12:51:20.012Z")
public class BooksApiServiceImpl extends BooksApiService {

    private static BookService bookService;
    private static UserService userService;
    private static ObjectMapper mapper;

    public BooksApiServiceImpl(BookService bookService, UserService userService){
        this.bookService = bookService;
        this.userService = userService;
        mapper = new ObjectMapper();
    }

    @Override
    public Response addBook(AddBookViewModel body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        bookService.addBook(body);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response addReview(Integer bookId, Integer userId, AddBookReviewViewModel body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        bookService.addReview((int) bookId, (int) userId, body);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteBook(Integer bookId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        bookService.deleteBook((int) bookId);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteBookReview(Integer bookId, Integer userId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        bookService.deleteBookReview((int)bookId, (int) userId);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteLoan(Integer bookId, Integer userId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        bookService.deleteLoan((int)bookId, (int)userId);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getAllBooks(SecurityContext securityContext) throws NotFoundException {
        return Response.ok(bookService.getAllBooks(), MediaType.APPLICATION_JSON).build();
    }
    @Override
    public Response getBookById(Integer bookId, SecurityContext securityContext) throws NotFoundException {
        return Response.ok(bookService.getBookById((int)bookId), MediaType.APPLICATION_JSON).build();
    }
    @Override
    public Response getBookLoanHistory(Integer bookId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getBookReviewsByBookId(BigDecimal bookId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        bookService.getBookReviewsByBookId(bookId.intValue());
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getBooksByRating(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        bookService.getBooksByRating();
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getLoanedBooksByDate(Date date, SecurityContext securityContext) throws NotFoundException {
        // do some magic!

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response loanBook(Integer bookId, Integer userId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        bookService.loanBook((int)bookId, (int)userId);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response returnBook(Integer bookId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        bookService.returnBook((int)bookId);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateBook(Integer bookId, AddBookViewModel body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        bookService.updateBook((int)bookId, body);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateBookLoan(Integer bookId, Integer userId, UpdateBookLoanViewModel body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        bookService.updateBookLoan((int)bookId, (int)userId, body);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}

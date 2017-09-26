package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.BooksApiService;
import io.swagger.api.factories.BooksApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

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

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/books")


@io.swagger.annotations.Api(description = "the books API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-26T11:45:59.080Z")
public class BooksApi  {
   private final BooksApiService delegate;

   public BooksApi(@Context ServletConfig servletContext) {
      BooksApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("BooksApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (BooksApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = BooksApiServiceFactory.getBooksApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add new book to the database", notes = "", response = void.class, tags={ "books", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = void.class) })
    public Response addBook(@ApiParam(value = "Book object, that needs to be added to the database" ,required=true) AddBookViewModel body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addBook(body,securityContext);
    }
    @POST
    @Path("/{bookId}/reviews/{userId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add new or update book review", notes = "", response = void.class, tags={ "book reviews", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = void.class) })
    public Response addReview(@ApiParam(value = "The ID of the book that the review belongs to",required=true) @PathParam("bookId") Long bookId
,@ApiParam(value = "The ID of the user that the review belongs to",required=true) @PathParam("userId") Long userId
,@ApiParam(value = "Review object, that needs to be added to book" ,required=true) AddBookReviewViewModel body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addReview(bookId,userId,body,securityContext);
    }
    @DELETE
    @Path("/{bookId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete book", notes = "", response = void.class, tags={ "books", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid book id supplied", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Book not found", response = void.class) })
    public Response deleteBook(@ApiParam(value = "The id of the book that needs to be deleted",required=true) @PathParam("bookId") Long bookId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteBook(bookId,securityContext);
    }
    @DELETE
    @Path("/{bookId}/reviews/{userId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete book review", notes = "", response = void.class, tags={ "book reviews", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid book id or user id supplied", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Book not found or user not found", response = void.class) })
    public Response deleteBookReview(@ApiParam(value = "The ID of the book that the review belongs to",required=true) @PathParam("bookId") Long bookId
,@ApiParam(value = "The ID of the user that the review belongs to",required=true) @PathParam("userId") Long userId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteBookReview(bookId,userId,securityContext);
    }
    @DELETE
    @Path("/{bookId}/loans/{userId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a loan that was registered. Should not be used to return books.", notes = "", response = void.class, tags={ "loans", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid book id or user id supplied", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Book not found or user not found", response = void.class) })
    public Response deleteLoan(@ApiParam(value = "The ID of the book that needs to be loaned",required=true) @PathParam("bookId") Long bookId
,@ApiParam(value = "The ID of the user that needs to loan the specifed book",required=true) @PathParam("userId") Long userId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteLoan(bookId,userId,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Gets all books", notes = "", response = BookViewModel.class, responseContainer = "List", tags={ "books", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = BookViewModel.class, responseContainer = "List") })
    public Response getAllBooks(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getAllBooks(securityContext);
    }
    @GET
    @Path("/{bookId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get book by book ID", notes = "", response = BookViewModel.class, tags={ "books", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = BookViewModel.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid book id supplied", response = BookViewModel.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Book not found", response = BookViewModel.class) })
    public Response getBookById(@ApiParam(value = "The ID of the book that needs to be fetched",required=true) @PathParam("bookId") Long bookId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getBookById(bookId,securityContext);
    }
    @GET
    @Path("/{bookId}/loans")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the loan history of the book, list of users", notes = "", response = BookLoanViewModel.class, responseContainer = "List", tags={ "loans", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = BookLoanViewModel.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid book id supplied", response = BookLoanViewModel.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Book not found", response = BookLoanViewModel.class, responseContainer = "List") })
    public Response getBookLoanHistory(@ApiParam(value = "The ID of the book that needs to be fetched",required=true) @PathParam("bookId") Long bookId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getBookLoanHistory(bookId,securityContext);
    }
    @GET
    @Path("/{bookId}/reviews")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Gets all book reviews", notes = "", response = BookReviewViewModel.class, responseContainer = "List", tags={ "book reviews", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = BookReviewViewModel.class, responseContainer = "List") })
    public Response getBookReviewsByBookId(@ApiParam(value = "The id of the book that the reviews belong to",required=true) @PathParam("bookId") BigDecimal bookId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getBookReviewsByBookId(bookId,securityContext);
    }
    @GET
    @Path("/recommendations")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Gets list of books sorted by rating, excludes unrated books", notes = "", response = BookViewModel.class, responseContainer = "List", tags={ "books", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = BookViewModel.class, responseContainer = "List") })
    public Response getBooksByRating(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getBooksByRating(securityContext);
    }
    @GET
    @Path("/loans/{date}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get list of books that are loaned out/unavailable at specified date or today by default and the user that has loaned it", notes = "", response = BookAndUserLoanViewModel.class, responseContainer = "List", tags={ "books","loans", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = BookAndUserLoanViewModel.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid date supplied", response = BookAndUserLoanViewModel.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Book not found", response = BookAndUserLoanViewModel.class, responseContainer = "List") })
    public Response getLoanedBooksByDate(@ApiParam(value = "The date specified to look up available books",required=true) @PathParam("date") Date date
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getLoanedBooksByDate(date,securityContext);
    }
    @POST
    @Path("/{bookId}/loans/{userId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Register book as loaned/borrowed by user", notes = "", response = void.class, tags={ "loans", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid id", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "book or user not found", response = void.class) })
    public Response loanBook(@ApiParam(value = "The ID of the book that needs to be loaned",required=true) @PathParam("bookId") Long bookId
,@ApiParam(value = "The ID of the user that needs to loan the specifed book",required=true) @PathParam("userId") Long userId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.loanBook(bookId,userId,securityContext);
    }
    @PUT
    @Path("/{bookId}/return")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Registers specific book as returned by user today", notes = "", response = void.class, tags={ "loans", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Book is not being loaned or has already been returned", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Book not found", response = void.class) })
    public Response returnBook(@ApiParam(value = "The ID of the book that needs to be returned",required=true) @PathParam("bookId") Long bookId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.returnBook(bookId,securityContext);
    }
    @PUT
    @Path("/{bookId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update book", notes = "", response = void.class, tags={ "books", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid book supplied", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Book not found", response = void.class) })
    public Response updateBook(@ApiParam(value = "Id of the book that needs to be updated",required=true) @PathParam("bookId") Long bookId
,@ApiParam(value = "Updated book object" ,required=true) AddBookViewModel body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateBook(bookId,body,securityContext);
    }
    @PUT
    @Path("/{bookId}/loans/{userId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Changes dates for book that is loaned/borrowed by user", notes = "", response = void.class, tags={ "loans", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid id", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "book or user not found", response = void.class) })
    public Response updateBookLoan(@ApiParam(value = "The ID of the book that needs to be updated",required=true) @PathParam("bookId") Long bookId
,@ApiParam(value = "The ID of the user that's loan needs be updated",required=true) @PathParam("userId") Long userId
,@ApiParam(value = "Date loaned and date returned values" ,required=true) UpdateBookLoanViewModel body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateBookLoan(bookId,userId,body,securityContext);
    }
}

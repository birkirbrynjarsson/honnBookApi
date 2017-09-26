package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.UsersApiService;
import io.swagger.api.factories.UsersApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.AddUserViewModel;
import java.math.BigDecimal;
import io.swagger.model.BookAndBookReviewViewModel;
import java.util.Date;
import io.swagger.model.UserAndBookLoansViewModel;
import io.swagger.model.UserViewModel;

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

@Path("/users")


@io.swagger.annotations.Api(description = "the users API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-26T11:45:59.080Z")
public class UsersApi  {
   private final UsersApiService delegate;

   public UsersApi(@Context ServletConfig servletContext) {
      UsersApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("UsersApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (UsersApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = UsersApiServiceFactory.getUsersApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add new user to the database", notes = "", response = void.class, tags={ "users", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = void.class) })
    public Response addUser(@ApiParam(value = "User object, that needs to be added to the database" ,required=true) AddUserViewModel body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addUser(body,securityContext);
    }
    @DELETE
    @Path("/{userId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete user", notes = "", response = void.class, tags={ "users", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid user id supplied", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = void.class) })
    public Response deleteUser(@ApiParam(value = "The Id of the user that needs to be deleted",required=true) @PathParam("userId") Long userId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteUser(userId,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Gets all users", notes = "", response = UserViewModel.class, responseContainer = "List", tags={ "users", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = UserViewModel.class, responseContainer = "List") })
    public Response getAllUsers(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getAllUsers(securityContext);
    }
    @GET
    @Path("/{userId}/reviews")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Gets all book reviews that belong to specific user", notes = "", response = BookAndBookReviewViewModel.class, responseContainer = "List", tags={ "book reviews", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = BookAndBookReviewViewModel.class, responseContainer = "List") })
    public Response getBookReviewsByUserId(@ApiParam(value = "The id of the user that the reviews belong to",required=true) @PathParam("userId") BigDecimal userId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getBookReviewsByUserId(userId,securityContext);
    }
    @GET
    @Path("/loans/{date}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get list of users that have a borrowed book at specified date or today by default. Includes the list of books that the user has loaned.", notes = "", response = UserAndBookLoansViewModel.class, responseContainer = "List", tags={ "users","loans", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = UserAndBookLoansViewModel.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid date supplied", response = UserAndBookLoansViewModel.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "No users found", response = UserAndBookLoansViewModel.class, responseContainer = "List") })
    public Response getUserAndLoanedBooksByDate(@ApiParam(value = "The date specified to look up users that have borrowed a book",required=true) @PathParam("date") Date date
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getUserAndLoanedBooksByDate(date,securityContext);
    }
    @GET
    @Path("/{userId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get user by user ID", notes = "", response = UserViewModel.class, tags={ "users", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = UserViewModel.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid user id supplied", response = UserViewModel.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = UserViewModel.class) })
    public Response getUserById(@ApiParam(value = "The ID of the user that needs to be fetched",required=true) @PathParam("userId") Long userId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getUserById(userId,securityContext);
    }
    @GET
    @Path("/loans/{date}/monthOverdue")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get list of users that have a book borrowed for a month or more at given date, defaults to today", notes = "", response = UserViewModel.class, responseContainer = "List", tags={ "users","loans", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = UserViewModel.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid date supplied", response = UserViewModel.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "No users found", response = UserViewModel.class, responseContainer = "List") })
    public Response getUsersWithMonthOverdueBooksByDate(@ApiParam(value = "The date specified to look up users that have borrowed a book",required=true) @PathParam("date") Date date
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getUsersWithMonthOverdueBooksByDate(date,securityContext);
    }
    @PUT
    @Path("/{userId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update user", notes = "", response = void.class, tags={ "users", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid user supplied", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = void.class) })
    public Response updateUser(@ApiParam(value = "Id of the user that needs to be updated",required=true) @PathParam("userId") Long userId
,@ApiParam(value = "Updated user object" ,required=true) AddUserViewModel body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateUser(userId,body,securityContext);
    }
}

package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.AddUserViewModel;
import java.math.BigDecimal;
import io.swagger.model.BookAndBookReviewViewModel;
import java.util.Date;
import io.swagger.model.UserAndBookLoansViewModel;
import io.swagger.model.UserViewModel;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-26T12:51:20.012Z")
public abstract class UsersApiService {
    public abstract Response addUser(AddUserViewModel body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteUser(Integer userId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAllUsers(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getBookReviewsByUserId(BigDecimal userId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getUserAndLoanedBooksByDate(Date date,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getUserById(Integer userId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getUsersWithMonthOverdueBooksByDate(Date date,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateUser(Integer userId,AddUserViewModel body,SecurityContext securityContext) throws NotFoundException;
}

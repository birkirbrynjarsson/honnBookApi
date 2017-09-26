package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import java.math.BigDecimal;
import java.util.Date;
import io.swagger.model.User;
import io.swagger.model.UserCurrentBooks;
import io.swagger.model.UserReview;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-25T22:03:01.666Z")
public abstract class UsersApiService {
    public abstract Response addUser(User body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteUser(Long userId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAllUsers(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getBookReviewsByUserId(BigDecimal userId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getUserAndLoanedBooksByDate(Date date,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getUserById(Long userId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getUsersWithMonthOverdueBooksByDate(Date date,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateUser(Long userId,User body,SecurityContext securityContext) throws NotFoundException;
}

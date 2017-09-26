/*
 * Johanna's Library
 * This is a book repository for Jóhanna the húsfreyja at Efri-Brú
 *
 * OpenAPI spec version: 1.0.0
 * Contact: birkirb15@ru.is
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.BookAndLoanViewModel;
import io.swagger.model.UserViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

/**
 * User and list of books
 */
@ApiModel(description = "User and list of books")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-26T12:51:20.012Z")
public class UserAndBookLoansViewModel   {
  @JsonProperty("user")
  private UserViewModel user = null;

  @JsonProperty("books")
  private List<BookAndLoanViewModel> books = null;

  public UserAndBookLoansViewModel user(UserViewModel user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
   **/
  @JsonProperty("user")
  @ApiModelProperty(value = "")
  public UserViewModel getUser() {
    return user;
  }

  public void setUser(UserViewModel user) {
    this.user = user;
  }

  public UserAndBookLoansViewModel books(List<BookAndLoanViewModel> books) {
    this.books = books;
    return this;
  }

  public UserAndBookLoansViewModel addBooksItem(BookAndLoanViewModel booksItem) {
    if (this.books == null) {
      this.books = new ArrayList<BookAndLoanViewModel>();
    }
    this.books.add(booksItem);
    return this;
  }

  /**
   * Get books
   * @return books
   **/
  @JsonProperty("books")
  @ApiModelProperty(value = "")
  public List<BookAndLoanViewModel> getBooks() {
    return books;
  }

  public void setBooks(List<BookAndLoanViewModel> books) {
    this.books = books;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAndBookLoansViewModel userAndBookLoansViewModel = (UserAndBookLoansViewModel) o;
    return Objects.equals(this.user, userAndBookLoansViewModel.user) &&
        Objects.equals(this.books, userAndBookLoansViewModel.books);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, books);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAndBookLoansViewModel {\n");
    
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    books: ").append(toIndentedString(books)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


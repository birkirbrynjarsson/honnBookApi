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
import io.swagger.model.UserViewModel;
import javax.validation.constraints.*;

/**
 * BookReviewViewModel
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-26T12:51:20.012Z")
public class BookReviewViewModel   {
  @JsonProperty("user")
  private UserViewModel user = null;

  @JsonProperty("rating")
  private Integer rating = null;

  @JsonProperty("review")
  private String review = null;

  public BookReviewViewModel user(UserViewModel user) {
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

  public BookReviewViewModel rating(Integer rating) {
    this.rating = rating;
    return this;
  }

  /**
   * Get rating
   * @return rating
   **/
  @JsonProperty("rating")
  @ApiModelProperty(value = "")
  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public BookReviewViewModel review(String review) {
    this.review = review;
    return this;
  }

  /**
   * Get review
   * @return review
   **/
  @JsonProperty("review")
  @ApiModelProperty(value = "")
  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookReviewViewModel bookReviewViewModel = (BookReviewViewModel) o;
    return Objects.equals(this.user, bookReviewViewModel.user) &&
        Objects.equals(this.rating, bookReviewViewModel.rating) &&
        Objects.equals(this.review, bookReviewViewModel.review);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, rating, review);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookReviewViewModel {\n");
    
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("    review: ").append(toIndentedString(review)).append("\n");
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


package is.ru.honn.service;

import io.swagger.model.AddUserViewModel;
import io.swagger.model.BookReviewViewModel;
import io.swagger.model.UserAndBookLoansViewModel;
import io.swagger.model.UserViewModel;

import java.util.Date;
import java.util.List;

public interface UserService
{
    void addUser(AddUserViewModel body);
    void deleteUser(int userId);
    List<UserViewModel> getAllUsers();
    List<BookReviewViewModel> getBookReviewByUserId(int userId);
    List<UserAndBookLoansViewModel> getUserAndLoanedBooksByDate(Date date);
    UserViewModel getUserById(int userId);
    List<UserViewModel> getUsersWithMonthOverdueBooksByDate(Date date);
    void updateUser(int userId, AddUserViewModel body);
}

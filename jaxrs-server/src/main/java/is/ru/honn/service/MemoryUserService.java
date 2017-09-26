package is.ru.honn.service;

import io.swagger.model.AddUserViewModel;
import io.swagger.model.BookReviewViewModel;
import io.swagger.model.UserAndBookLoansViewModel;
import io.swagger.model.UserViewModel;

import java.util.Date;
import java.util.List;

public class MemoryUserService implements UserService
{
    @Override
    public void addUser(AddUserViewModel body) {

    }

    @Override
    public void deleteUser(int userId) {

    }

    @Override
    public List<UserViewModel> getAllUsers() {
        return null;
    }

    @Override
    public List<BookReviewViewModel> getBookReviewByUserId(int userId) {
        return null;
    }

    @Override
    public UserAndBookLoansViewModel getUserAndLoanedBooksByDate(Date date) {
        return null;
    }

    @Override
    public UserViewModel getUserById(int userId) {
        return null;
    }

    @Override
    public UserAndBookLoansViewModel getUsersWithMonthOverdueBooksByDate(Date date) {
        return null;
    }

    @Override
    public void updateUser(int userId, AddUserViewModel body) {

    }
}

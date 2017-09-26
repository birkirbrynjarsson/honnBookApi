package is.ru.honn.service;

import io.swagger.model.*;
import is.ru.honn.model.BookLoan;
import is.ru.honn.model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemoryUserService implements UserService
{
    private static BookService bookService;
    private static ArrayList<User> users = new ArrayList<User>();

    public MemoryUserService(){
        if(users.isEmpty()){
            String fileUsers = System.getProperty("user.dir") + "/json/users.json";
            JSONParser jsonParser = new JSONParser();
            List<JSONObject> jsonUsers = new ArrayList<JSONObject>();
            try {
                JSONArray objArray = (JSONArray) jsonParser.parse(new FileReader(fileUsers));
                for(Object book : objArray){
                    jsonUsers.add((JSONObject) book);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            for(JSONObject jsonUser : jsonUsers){
                int userId = ((Long)jsonUser.get("userid")).intValue();
                User user = new User(
                        userId,
                        (String)jsonUser.get("firstname"),
                        (String)jsonUser.get("lastname"),
                        (String)jsonUser.get("address"),
                        (String)jsonUser.get("email"),
                        null
                );
                users.add(user);
            }
        }
    }

    private int newId(){
        int maxId = 0;
        for (int i = 0; i < users.size(); i++){
            maxId = users.get(i).getId() > maxId ? users.get(i).getId() : maxId;
        }
        return maxId + 1;
    }

    @Override
    public void addUser(AddUserViewModel user) {
        User newUser = new User(newId(), user.getFirstName(), user.getLastName(), user.getAddress(), user.getEmail(), user.getPhone());
        users.add(newUser);
    }

    @Override
    public void deleteUser(int userId) {
        int index = 0;
        boolean userFound = false;
        for(; index < users.size(); index++){
            if(users.get(index).getId() == userId){
                userFound = true;
                break;
            }
        }
        if(userFound){
            users.remove(index);
        }
    }

    @Override
    public List<UserViewModel> getAllUsers() {
        List<UserViewModel> returnedUsers = new ArrayList<UserViewModel>();
        for(int i = 0; i < users.size(); i++){
            UserViewModel user = new UserViewModel();
            user.id((Integer)users.get(i).getId());
            user.firstName(users.get(i).getFirstName());
            user.lastName(users.get(i).getLastName());
            user.address(users.get(i).getAddress());
            user.email(users.get(i).getEmail());
            user.phone(users.get(i).getPhone());
            returnedUsers.add(user);
        }
        return returnedUsers;
    }

    @Override
    public List<BookReviewViewModel> getBookReviewByUserId(int userId) {
        if(getUserById(userId) == null) {
            return null;
        }
        return bookService.getBookReviewByUserId(userId);
    }

    @Override
    public List<UserAndBookLoansViewModel> getUserAndLoanedBooksByDate(Date date) {
        List<UserAndBookLoansViewModel> models = new ArrayList<UserAndBookLoansViewModel>();
        List<BookLoan> bookLoans = bookService.getBookLoans();
        for(int i = 0; i < users.size(); i++){
            UserAndBookLoansViewModel userModel = new UserAndBookLoansViewModel();
            userModel.setUser(getUserById(users.get(i).getId()));
            List<BookAndLoanViewModel> bookLoanList = new ArrayList<BookAndLoanViewModel>();
            for(int j = 0; j < bookLoans.size(); j++){
                if(users.get(i).getId() == bookLoans.get(j).getUserId()){
                    if(bookLoans.get(j).getDateLoaned().before(date) && (bookLoans.get(j).getDateReturned() == null || bookLoans.get(j).getDateReturned().after(date))){
                        BookViewModel book = bookService.getBookById(bookLoans.get(j).getBookId());
                        BookAndLoanViewModel bookLoan = new BookAndLoanViewModel();
                        bookLoan.setDateLoaned(bookLoans.get(j).getDateLoaned());;
                        bookLoan.setDatePublished(book.getDatePublished());
                        bookLoan.setDateReturned(bookLoans.get(j).getDateReturned());
                        bookLoan.setFirstName(book.getFirstName());
                        bookLoan.setLastName(book.getLastName());
                        bookLoan.setId(book.getId());
                        bookLoan.setIsbn(book.getIsbn());
                        bookLoan.setTitle(book.getTitle());
                        bookLoanList.add(bookLoan);
                    }
                }
            }
            if(!bookLoanList.isEmpty()){
                userModel.setBooks(bookLoanList);
                models.add(userModel);
            }
        }
        return models;
    }

    @Override
    public UserViewModel getUserById(int userId) {
        int index = 0;
        boolean userFound = false;
        for(; index < users.size(); index++){
            if(users.get(index).getId() == userId){
                userFound = true;
                break;
            }
        }
        if(userFound){
            UserViewModel returnedUser = new UserViewModel();
            returnedUser.id((Integer)users.get(index).getId());
            returnedUser.firstName(users.get(index).getFirstName());
            returnedUser.lastName(users.get(index).getLastName());
            returnedUser.address(users.get(index).getAddress());
            returnedUser.email(users.get(index).getEmail());
            returnedUser.phone(users.get(index).getPhone());
            return returnedUser;
        }
        return null;
    }

    @Override
    public List<UserViewModel> getUsersWithMonthOverdueBooksByDate(Date date) {
        long monthMs = 2592000000L;
        List<UserViewModel> models = new ArrayList<UserViewModel>();
        List<BookLoan> bookLoans = bookService.getBookLoans();
        for(int i = 0; i < users.size(); i++){
            for(int j = 0; j < bookLoans.size(); j++){
                if(users.get(i).getId() == bookLoans.get(j).getUserId()){
                    if(bookLoans.get(j).getDateLoaned().before(date) && (bookLoans.get(j).getDateReturned() == null || bookLoans.get(j).getDateReturned().after(date))){
                        if((date.getTime() - bookLoans.get(j).getDateLoaned().getTime()) > monthMs){
                            models.add(getUserById(users.get(i).getId()));
                        }
                    }
                }
            }
        }
        return models;
    }

    @Override
    public void updateUser(int userId, AddUserViewModel user) {
        int index = 0;
        boolean userFound = false;
        for(; index < users.size(); index++){
            if(users.get(index).getId() == userId){
                userFound = true;
                break;
            }
        }
        if(userFound){
            users.get(index).setFirstName(user.getFirstName());
            users.get(index).setLastName(user.getLastName());
            users.get(index).setAddress(user.getAddress());
            users.get(index).setEmail(user.getEmail());
            users.get(index).setPhone(user.getPhone());
        }
    }
}

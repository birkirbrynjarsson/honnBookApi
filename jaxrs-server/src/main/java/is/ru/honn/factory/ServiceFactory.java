package is.ru.honn.factory;

import is.ru.honn.service.BookService;
import is.ru.honn.service.MemoryBookService;
import is.ru.honn.service.MemoryUserService;
import is.ru.honn.service.UserService;

public class ServiceFactory
{
    private static UserService userService;
    private static BookService bookService;

    public static UserService getUserService()
    {
        if(userService == null)
            userService = new MemoryUserService();
        return userService;
    }

    public static BookService getBookService()
    {
        if(bookService == null)
            bookService = new MemoryBookService();
        return bookService;
    }
}

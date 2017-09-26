package is.ru.honn.factory;

import is.ru.honn.service.BookService;
import is.ru.honn.service.MemoryBookService;
import is.ru.honn.service.MemoryUserService;
import is.ru.honn.service.UserService;

public class ServiceFactory
{
    private static UserService us;
    private static BookService bs;

    public static UserService getUserService()
    {
        if(us == null)
            us = new MemoryUserService();
        return us;
    }

    public static BookService getBookService()
    {
        if(bs == null)
            bs = new MemoryBookService();
        return bs;
    }
}

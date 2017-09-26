package io.swagger.api.factories;

import io.swagger.api.BooksApiService;
import io.swagger.api.impl.BooksApiServiceImpl;
import is.ru.honn.factory.ServiceFactory;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-26T12:51:20.012Z")
public class BooksApiServiceFactory {
    private final static BooksApiService service = new BooksApiServiceImpl(ServiceFactory.getBookService(), ServiceFactory.getUserService());

    public static BooksApiService getBooksApi() {
        return service;
    }
}

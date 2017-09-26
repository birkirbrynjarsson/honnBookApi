package io.swagger.api.factories;

import io.swagger.api.UsersApiService;
import io.swagger.api.impl.UsersApiServiceImpl;
import is.ru.honn.factory.ServiceFactory;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-26T12:51:20.012Z")
public class UsersApiServiceFactory {
    private final static UsersApiService service = new UsersApiServiceImpl(ServiceFactory.getUserService(), ServiceFactory.getBookService());

    public static UsersApiService getUsersApi() {
        return service;
    }
}

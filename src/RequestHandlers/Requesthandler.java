package RequestHandlers;

import Model.User;
import Model.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Requesthandler {
    protected UserService service;

    public void setService(UserService service){
        this.service = service;
    }

    public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

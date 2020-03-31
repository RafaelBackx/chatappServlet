package Controller;
import Model.User;
import Model.UserService;
import RequestHandlers.RequestHandlerFactory;
import RequestHandlers.Requesthandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import java.io.IOException;

@WebServlet("/Controller")
public class Servlet extends javax.servlet.http.HttpServlet {
    private UserService service = new UserService();

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request,response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response){
        String command = request.getParameter("command") != null ? request.getParameter("command") : "";
        Requesthandler handler = RequestHandlerFactory.createHandler(command);
        try{
            handler.setService(this.service);
            handler.handleRequest(request,response);
        }catch (NullPointerException e){
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package RequestHandlers;

import Model.Status;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Statement;

public class Login extends Requesthandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User u = service.getLoggedIn(username,password);
        if (u!=null){
            u.setStatus(Status.ONLINE);
            session.setAttribute("user",u);
        }
        request.setAttribute("statuses", Status.values());
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }
}

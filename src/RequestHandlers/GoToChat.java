package RequestHandlers;

import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToChat extends Requesthandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User friend = service.getUser(request.getParameter("friend"));
        request.setAttribute("friend",friend);
        request.getRequestDispatcher("chat.jsp").forward(request,response);
    }
}

package RequestHandlers;

import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddFriend extends Requesthandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");
        if (u != null){
            u.addFriend(service.getUser(request.getParameter("name")));
            System.out.println(u.getFriendlist().size());
        }
    }
}

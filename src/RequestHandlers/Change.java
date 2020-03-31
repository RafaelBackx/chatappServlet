package RequestHandlers;

import Model.Status;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Change extends Requesthandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        Status s = Status.OTHER;
        try{
            s = Status.valueOf(status);
        }catch (IllegalArgumentException e){
            s.setName(status);
        }
        User u =(User) request.getSession().getAttribute("user");
        u.setStatus(s);
        System.out.println(u.getStatus().getName());
        response.getWriter().write(u.getName() + " - " + s.getName());
    }
}

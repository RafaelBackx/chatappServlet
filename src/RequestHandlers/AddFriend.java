package RequestHandlers;

import Model.User;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class AddFriend extends Requesthandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");
        if (u != null){
            u.addFriend(service.getUser(request.getParameter("name")));
            response.getWriter().write(toJson(u.getFriendlist()));
            System.out.println(u.getFriendlist().size());
        }
    }

    private String toJson(Set<User> list){
        JsonObject json = new JsonObject();
        for (User u:list){
            JsonObject user = new JsonObject();
            user.addProperty("name",u.getName());
            user.addProperty("statusname",u.getStatus().getName());
            json.add(u.getName(),user);
        }
        return json.toString();
    }
}

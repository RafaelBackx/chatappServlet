package RequestHandlers;

import Model.Message;
import Model.User;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class Chat extends Requesthandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User friend = service.getUser(request.getParameter("friend"));
        User sessionUser = (User) request.getSession().getAttribute("user");
        String message = request.getParameter("message");
        sessionUser.sendMessage(friend,message);
        List<Message> messageHistory = new ArrayList<>();
        messageHistory.addAll(sessionUser.getMessages(friend));
        messageHistory.addAll(friend.getMessages(sessionUser));
        Collections.sort(messageHistory);
        response.getWriter().write(toJson(messageHistory,sessionUser));
    }

    private String toJson(List<Message> list,User sessionsuser){
        JsonObject json = new JsonObject();
        for (Message m:list){
            String position = m.getSender().equals(sessionsuser) ? "right" : "left";
            JsonObject message = new JsonObject();
            message.addProperty("data",m.getData());
            message.addProperty("position",position);
            json.add(m.getTime().toString(),message);
        }
        return json.toString();
    }
}

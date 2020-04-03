package Controller;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/forum")
public class CommentController {
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());
    @OnOpen
    public void open(Session session){
        sessions.add(session);
        System.out.println("open");
    }

    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println("user " + session.getId() + " said: " + message);
        broadcast(message);
    }

    @OnClose
    public void onClose(Session session){
        sessions.remove(session);
    }

    public void broadcast(String message){
        for (Session s: sessions){
            try {
                s.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

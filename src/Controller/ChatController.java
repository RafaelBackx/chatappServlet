//package Controller;
//
//import Model.User;
//import Model.UserService;
//
//import javax.servlet.http.HttpSession;
//import javax.websocket.OnClose;
//import javax.websocket.OnMessage;
//import javax.websocket.OnOpen;
//import javax.websocket.Session;
//import javax.websocket.server.ServerEndpoint;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//
//@ServerEndpoint("/chat")
//public class ChatController {
//
//    private static Map<User, Session> userSessionMap = Collections.synchronizedMap(new HashMap<>());
//    private UserService service = new UserService();
//
//    @OnOpen
//    public void onOpen(HttpSession session){
//        userSessionMap.put(session.get)
//    }
//
//    @OnMessage
//    public void onMessage(String message,Session session){}
//
//    @OnClose
//    public void onClose(Session session){
//
//    }
//}


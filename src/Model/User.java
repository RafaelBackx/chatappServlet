package Model;

import java.util.*;

public class User {
    private String name;
    private Status status;
    private String password;
    private String statusname;
    private Set<User> friendlist;
    private Map<User, List<Message>> messages;

    public User(String name,String password, Status status) {
        this.name = name;
        this.password = password;
        this.status = status;
        this.statusname = status.getName();
        friendlist = new HashSet<>();
        messages = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public String getPassword(){return password;}

    public String getStatusname() {
        return statusname;
    }

    public void addFriend(User u){
        if (u != null){
            this.friendlist.add(u);
        }
    }

    public Set<User> getFriendlist(){
        return friendlist;
    }

    public String toString(){
        return name + " - "  + statusname;
    }

    public void setStatus(Status s){
        this.status = s;
        this.statusname = s.getName();
    }

    public void sendMessage(User receiver,String message){
        if (contains(this.messages,receiver) != null){
            List<Message> messages = contains(this.messages,receiver);
            messages.add(new Message(this,receiver,message));
            System.out.println(messages);
        }else{
            List<Message> m = new ArrayList<>();
            m.add(new Message(this,receiver,message));
             messages.put(receiver,m);
        }
    }

    private List<Message> contains(Map<User,List<Message>> map,User u){
        for (Map.Entry<User,List<Message>> entry:map.entrySet()){
            if (entry.getKey().equals(u)){
                return entry.getValue();
            }
        }
        return null;
    }

    public List<Message> getMessages(User receiver){
        return contains(this.messages,receiver) != null ? contains(this.messages,receiver) : new ArrayList<>();
    }


    public boolean equals(Object o){
        if (o instanceof User){
            return this.name.equalsIgnoreCase(((User) o).name);
        }
        return false;
    }
}

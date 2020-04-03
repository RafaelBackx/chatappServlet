package Model;

import java.time.LocalDateTime;

public class Message implements Comparable<Message> {
    private String data;
    private LocalDateTime time;
    private User sender,receiver;

    public Message(User sender,User receiver,String data,LocalDateTime time){
        this.sender = sender;
        this.receiver = receiver;
        this.data = data;
        this.time = time;
    }
    public Message(User sender,User receiver,String data){
        this(sender,receiver,data,LocalDateTime.now());
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @Override
    public int compareTo(Message o) {
        return this.time.compareTo(o.time);
    }
}

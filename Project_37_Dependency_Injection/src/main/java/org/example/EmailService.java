package org.example;

import java.util.List;

public class EmailService implements MessageService{

    private String object;
    private List<String> destination;
    private String message;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<String> getDestination() {
        return destination;
    }

    public void setDestination(List<String> destination) {
        this.destination = destination;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean sendMessage() {
        if(this.object == null || this.message == null || this.destination == null)
            return false;

        System.out.println("Email object: "+this.object+", Message: "+this.message);
        this.destination.forEach(System.out::println);
        return true;
    }
}

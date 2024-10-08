package org.example;

import java.util.List;

public class EmailService implements MessageService{
    public void setObject(String object) {
        this.object = object;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDestination(List<String> destination) {
        this.destination = destination;
    }

    public String getObject() {
        return object;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getDestination() {
        return destination;
    }

    private String object;
    private String message;
    private List<String> destination;

    @Override
    public boolean sendMessage() {
        if(this.object == null || this.message == null || this.destination == null)
            return false;

        System.out.println("Email object: "+this.object+", Message: "+this.message);
        this.destination.forEach(System.out::println);
        return true;
    }
}

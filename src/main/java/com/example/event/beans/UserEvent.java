package com.example.event.beans;

public class UserEvent extends GenericEvent<String> {


    public UserEvent(String source) {
        super(source);
    }
}

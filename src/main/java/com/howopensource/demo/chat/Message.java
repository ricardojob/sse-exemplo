package com.howopensource.demo.chat;

/**
 * This class represents simple message with just two attributes - id and
 * message.
 */
public class Message {

    private long id;
    private String message;

    public Message(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

}

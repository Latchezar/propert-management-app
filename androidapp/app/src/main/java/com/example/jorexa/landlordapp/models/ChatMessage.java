package com.example.jorexa.landlordapp.models;

import java.io.Serializable;
import java.security.Timestamp;


public class ChatMessage implements Serializable {
    public long messageID;
    public int messageType, propertyID, senderID;
    public String messageText;

    public ChatMessage() {

    }

    public ChatMessage(long messageID, int messageType, int propertyID, int senderID, String messageText) {
        this.messageID = messageID;
        this.messageType = messageType;
        this.propertyID = propertyID;
        this.senderID = senderID;
        this.messageText = messageText;
    }


    public long getMessageID() {
        return messageID;
    }

    public void setMessageID(long messageID) {
        this.messageID = messageID;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

}

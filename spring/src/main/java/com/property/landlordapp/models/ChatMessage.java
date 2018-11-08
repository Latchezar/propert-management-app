package com.property.landlordapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "chat", uniqueConstraints = {
        @UniqueConstraint(columnNames = "MessageID")
})
public class ChatMessage {

    @Id
    @Column(name = "MessageID")
    private Timestamp timestamp;

    @Column(name = "MessageType")
    private int messageType;

    @Column(name = "PropertyID")
    private int propertyID;

    @Column(name = "SenderID")
    private int senderID;

    @Column(name = "MessageText")
    private String messageText;

    private long messageID;

    public ChatMessage() {
    }

    public ChatMessage(Timestamp timestamp, int messageType, int propertyID, int senderID, String messageText) {
        this.timestamp = timestamp;
        this.messageType = messageType;
        this.propertyID = propertyID;
        this.senderID = senderID;
        this.messageText = messageText;
    }

    @JsonIgnore
    @JsonProperty(value = "timestamp")
    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        setMessageID(timestamp.getTime());
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
        return this.senderID;
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

    public long getMessageID() {
        return messageID;
    }

    public void setMessageID(long messageID) {
        this.messageID = messageID;
    }
}

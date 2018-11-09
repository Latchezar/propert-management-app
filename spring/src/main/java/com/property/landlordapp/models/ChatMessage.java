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
    private Timestamp messageID;

    @Column(name = "MessageType")
    private int messageType;

    @Column(name = "PropertyID")
    private int propertyID;

    @Column(name = "SenderID")
    private int senderID;

    @Column(name = "MessageText")
    private String messageText;

    @Transient
    private long milliseconds;

    public ChatMessage() {
    }

    public ChatMessage(Timestamp messageID, int messageType, int propertyID, int senderID, String messageText, long milliseconds) {
        this.messageID = messageID;
        this.messageType = messageType;
        this.propertyID = propertyID;
        this.senderID = senderID;
        this.messageText = messageText;
        this.milliseconds = milliseconds;
    }

    @JsonIgnore
    @JsonProperty(value = "messageID")
    public Timestamp getMessageID() {
        return this.messageID;
    }

    public void setMessageID(Timestamp timestamp) {
        this.messageID = timestamp;
        setMilliseconds(timestamp.getTime());
    }

    public void setMessageIDByMilliseconds(Long milliseconds){
        this.messageID = new Timestamp(milliseconds);
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

    public long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }
}

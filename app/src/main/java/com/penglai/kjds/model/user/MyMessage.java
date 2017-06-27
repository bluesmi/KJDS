package com.penglai.kjds.model.user;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/27.
 */

public class MyMessage implements Serializable {
    private String iD;
    private String userName;
    private String messageType;
    private String title;
    private String content;
    private String sendTime;

    public MyMessage(String iD, String userName, String messageType, String title, String content, String sendTime) {
        this.iD = iD;
        this.userName = userName;
        this.messageType = messageType;
        this.title = title;
        this.content = content;
        this.sendTime = sendTime;
    }

    public MyMessage() {
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyMessage myMessage = (MyMessage) o;

        if (iD != null ? !iD.equals(myMessage.iD) : myMessage.iD != null) return false;
        if (userName != null ? !userName.equals(myMessage.userName) : myMessage.userName != null)
            return false;
        if (messageType != null ? !messageType.equals(myMessage.messageType) : myMessage.messageType != null)
            return false;
        if (title != null ? !title.equals(myMessage.title) : myMessage.title != null) return false;
        if (content != null ? !content.equals(myMessage.content) : myMessage.content != null)
            return false;
        return sendTime != null ? sendTime.equals(myMessage.sendTime) : myMessage.sendTime == null;

    }

    @Override
    public int hashCode() {
        int result = iD != null ? iD.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (messageType != null ? messageType.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (sendTime != null ? sendTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "iD='" + iD + '\'' +
                ", userName='" + userName + '\'' +
                ", messageType='" + messageType + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sendTime='" + sendTime + '\'' +
                '}';
    }
}

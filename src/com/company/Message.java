package com.company;

public class Message {
    String date;
    String message;
    String person;
    String hour;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Message{" +
                "date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", message='" + message + '\'' +
                ", person='" + person + '\'' +
                '}';
    }

    public Message(String date, String hour, String person, String message) {
        this.hour = hour;
        this.date = date;
        this.message = message;
        this.person = person;
    }
}

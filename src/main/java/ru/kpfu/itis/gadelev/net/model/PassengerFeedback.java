package ru.kpfu.itis.gadelev.net.model;

public class PassengerFeedback {
    int id;
    int passenger_id;
    String text;

    public PassengerFeedback(int id, int passenger_id, String text) {
        this.id = id;
        this.passenger_id = passenger_id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(int passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

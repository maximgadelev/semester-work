package ru.kpfu.itis.gadelev.net.dto;

public class DriverFeedbackDto {
    int id;
    int driver_id;
    String text;
    int passenger_id;

    public DriverFeedbackDto(int id, int driver_id, String text,int passenger_id) {
        this.id = id;
        this.driver_id = driver_id;
        this.text = text;
        this.passenger_id = passenger_id;
    }

    public int getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(int passenger_id) {
        this.passenger_id = passenger_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

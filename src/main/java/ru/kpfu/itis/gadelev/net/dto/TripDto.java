package ru.kpfu.itis.gadelev.net.dto;

public class TripDto {
    private String date;
    private int price;
    private String path;
    private String time;

    public TripDto(String date, int price, String path, String time) {
        this.date = date;
        this.price = price;
        this.path = path;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

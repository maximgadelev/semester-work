package ru.kpfu.itis.gadelev.net.model;

public class Trip {
    private int id;
    private int admin_id;
    private int car_id;
    private String date;
    private int price;
    private String path;
    private String time;

    public Trip(int id, int admin_id, int car_id, String date, int price, String path, String time) {
        this.id = id;
        this.admin_id = admin_id;
        this.car_id = car_id;
        this.date = date;
        this.price = price;
        this.path = path;
        this.time = time;
    }

    public Trip(int admin_id, int car_id, String date, int price, String path, String time) {
        this.admin_id = admin_id;
        this.car_id = car_id;
        this.date = date;
        this.price = price;
        this.path = path;
        this.time = time;
    }

    public Trip(String date, int price, String path, String time) {
        this.date = date;
        this.price = price;
        this.path = path;
        this.time = time;
    }

    public Trip(int car_id, String date, int price, String path, String time) {
        this.car_id = car_id;
        this.date = date;
        this.price = price;
        this.path = path;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
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

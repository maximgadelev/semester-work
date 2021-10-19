package ru.kpfu.itis.gadelev.net.model;

public class Car {
    private int id;
    private int driverId;
    private String brand;
    private String number;
    private int numberOfPlaces;
    private String model;

    public Car(int id, int driverId, String brand, String number, int numberOfPlaces,String model) {
        this.id = id;
        this.driverId = driverId;
        this.brand = brand;
        this.number = number;
        this.numberOfPlaces = numberOfPlaces;
        this.model=model;
    }

    public Car(String brand, String number, int numberOfPlaces,String model) {
        this.brand = brand;
        this.number = number;
        this.numberOfPlaces = numberOfPlaces;
        this.model=model;
    }

    public Car(int driverId, String brand, String number, int numberOfPlaces, String model) {
        this.driverId = driverId;
        this.brand = brand;
        this.number = number;
        this.numberOfPlaces = numberOfPlaces;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}



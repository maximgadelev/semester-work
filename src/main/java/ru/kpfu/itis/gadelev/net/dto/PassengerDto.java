package ru.kpfu.itis.gadelev.net.dto;

public class PassengerDto {
    private String name;
    private String surname;
    private String login;
    private double rating;

    public PassengerDto(String name, String surname, String login,double rating) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.rating=rating;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}


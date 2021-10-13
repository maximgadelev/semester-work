package ru.kpfu.itis.gadelev.net.dto;

public class DriverDto {
    private String name;
    private String surname;
    private String login;
    private double rating;
    private String date_of_birth;

    public DriverDto(String name, String surname, String login,double rating,String dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.rating=rating;
        this.date_of_birth =dateOfBirth;
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

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
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

package ru.kpfu.itis.gadelev.net.dto;

public class DriverDto {
    private int id;
    private String name;
    private String surname;
    private String login;
    private double rating;
    private String date_of_birth;
    private String profile_image;

    public DriverDto(int id,String profile_image,String name, String surname, String login,double rating,String dateOfBirth) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.rating=rating;
        this.date_of_birth =dateOfBirth;
        this.profile_image=profile_image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
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

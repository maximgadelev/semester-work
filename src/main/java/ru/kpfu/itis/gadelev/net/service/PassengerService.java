package ru.kpfu.itis.gadelev.net.service;

import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.model.Passenger;

import java.util.List;

public interface PassengerService<T> {
    PassengerDto get(int id);
PassengerDto getByLogin(String login);
    List<PassengerDto> getAll();

    boolean save(Passenger passenger);
    void changePhoto(int id,String url);
    void updateRating(int id,double rating);


}


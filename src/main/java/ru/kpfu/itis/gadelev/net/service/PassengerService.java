package ru.kpfu.itis.gadelev.net.service;

import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.model.Passenger;

import java.util.List;

public interface PassengerService<T> {
    PassengerDto get(int id);

    List<PassengerDto> getAll();

    void save(Passenger passenger);
}


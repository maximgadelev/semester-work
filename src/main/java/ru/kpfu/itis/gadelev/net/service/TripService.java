package ru.kpfu.itis.gadelev.net.service;

import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.dto.TripDto;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.model.Trip;

import java.util.List;

public interface TripService {
    TripDto get(int id);

    List<TripDto> getAll();

    boolean save(Trip trip);

    List<TripDto> getBySearch(String path,String date,String time);
}

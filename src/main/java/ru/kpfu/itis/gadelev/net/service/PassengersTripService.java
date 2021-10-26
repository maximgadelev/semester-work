package ru.kpfu.itis.gadelev.net.service;

import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.dto.TripDto;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.model.Trip;

import java.util.List;

public interface PassengersTripService {

    List<PassengerDto> getPassengerByTrip(int trip_id);
    List<TripDto> getPassengerTripsByStatus(int passenger_id,String status);
    boolean savePassengerTrip(int passenger_id, int trip_id);
}

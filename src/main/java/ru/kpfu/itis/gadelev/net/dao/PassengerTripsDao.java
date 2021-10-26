package ru.kpfu.itis.gadelev.net.dao;

import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.model.Trip;

import java.util.List;

public interface PassengerTripsDao<T> {
    List<T> getPassengerByTrip(int trip_id);
    List<T> getPassengerTripsByStatus(int passenger_id,String status);
    boolean savePassengerTrip(int passenger_id, int trip_id);
}

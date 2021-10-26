package ru.kpfu.itis.gadelev.net.service.impl;

import ru.kpfu.itis.gadelev.net.dao.PassengerTripsDao;
import ru.kpfu.itis.gadelev.net.dao.impl.PassengerTripsDaoImpl;
import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.dto.TripDto;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.model.Trip;
import ru.kpfu.itis.gadelev.net.service.PassengersTripService;

import java.util.List;
import java.util.stream.Collectors;

public class PassengersTripServiceImpl implements PassengersTripService {
    private final PassengerTripsDao passengerTripsDao = new PassengerTripsDaoImpl();
    @Override
    public List<PassengerDto> getPassengerByTrip(int trip_id) {
        return null;
    }

    @Override
    public List<TripDto> getPassengerTripsByStatus(int passenger_id,String status) {
       List<Trip> trips = passengerTripsDao.getPassengerTripsByStatus(passenger_id,status);
       return trips.stream().map(trip -> new TripDto(
               trip.getId(),
               trip.getAdmin_id(),
               trip.getCar_id(),
               trip.getDate(),
               trip.getPrice(),
               trip.getPath(),
               trip.getTime(),
               trip.getNotFreePlaces(),
               trip.getFreePlaces(),
               trip.getStatus()
       )).collect(Collectors.toList());
    }

    @Override
    public boolean savePassengerTrip(int passenger_id, int trip_id) {
        return passengerTripsDao.savePassengerTrip(passenger_id,trip_id);
    }
}

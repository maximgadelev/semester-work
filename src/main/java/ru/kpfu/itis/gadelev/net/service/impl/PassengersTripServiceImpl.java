package ru.kpfu.itis.gadelev.net.service.impl;

import ru.kpfu.itis.gadelev.net.dao.PassengerTripsDao;
import ru.kpfu.itis.gadelev.net.dao.impl.PassengerTripsDaoImpl;
import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.dto.TripDto;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.model.Trip;
import ru.kpfu.itis.gadelev.net.service.PassengersTripService;

import java.util.List;

public class PassengersTripServiceImpl implements PassengersTripService {
    private final PassengerTripsDao passengerTripsDao = new PassengerTripsDaoImpl();
    @Override
    public List<PassengerDto> getPassengerByTrip(int trip_id) {
        return null;
    }

    @Override
    public List<TripDto> getPassengerTrips(int passenger_id) {
        return null;
    }

    @Override
    public boolean savePassengerTrip(int passenger_id, int trip_id) {
        return passengerTripsDao.savePassengerTrip(passenger_id,trip_id);
    }
}

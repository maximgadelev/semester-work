package ru.kpfu.itis.gadelev.net.service.impl;

import ru.kpfu.itis.gadelev.net.dao.CarDao;
import ru.kpfu.itis.gadelev.net.dao.TripDao;
import ru.kpfu.itis.gadelev.net.dao.impl.CarDaoImpl;
import ru.kpfu.itis.gadelev.net.dao.impl.TripDaoImpl;
import ru.kpfu.itis.gadelev.net.dto.TripDto;
import ru.kpfu.itis.gadelev.net.model.Car;
import ru.kpfu.itis.gadelev.net.model.Trip;
import ru.kpfu.itis.gadelev.net.service.TripService;

import java.util.List;
import java.util.stream.Collectors;

public class TripServiceImpl implements TripService {
    private final TripDao<Trip> tripDao = new TripDaoImpl();
    @Override
    public TripDto get(int id) {
        return null;
    }

    @Override
    public List<TripDto> getAll() {
        return null;
    }

    @Override
    public boolean save(Trip trip) {
        return tripDao.save(new Trip(
                trip.getAdmin_id(),
                trip.getCar_id(),
                trip.getDate(),
                trip.getPrice(),
                trip.getPath(),
                trip.getTime(),
                trip.getNotFreePlaces(),
                trip.getFreePlaces()
        ));
    }

    @Override
    public List<TripDto> getBySearch(String date, String time, String path) {
       List<Trip> trips =tripDao.getBySearch(date,time,path);
        return trips.stream().map(trip->new TripDto(
                trip.getId(),
                trip.getAdmin_id(),
                trip.getCar_id(),
                trip.getDate(),
                trip.getPrice(),
                trip.getPath(),
                trip.getTime(),
                trip.getNotFreePlaces(),
                trip.getFreePlaces())
        ).collect(Collectors.toList());
    }
}

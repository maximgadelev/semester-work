package ru.kpfu.itis.gadelev.net.dao;

import ru.kpfu.itis.gadelev.net.model.Trip;

import java.util.List;

public interface TripDao<T> {
    List<T> getTripsByDriverId(int driver_id,String status);
    void changeFreePlaces(int trip_id, int places);
    List<T> getAll();
    T getById(int trip_id);
    boolean save(T t);
    List<T> getBySearch(String date,String time,String path,int freePlaces);
    void changeStatus(int id);
}

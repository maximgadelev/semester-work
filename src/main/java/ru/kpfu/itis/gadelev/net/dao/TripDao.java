package ru.kpfu.itis.gadelev.net.dao;

import ru.kpfu.itis.gadelev.net.model.Trip;

import java.util.List;

public interface TripDao<T> {
    T get(int car_id);
    T getById(int trip_id);
    void changeFreePlaces(int trip_id, int places);
    List<T> getAll();

    boolean save(T t);
    List<T> getBySearch(String date,String time,String path,int freePlaces);
}

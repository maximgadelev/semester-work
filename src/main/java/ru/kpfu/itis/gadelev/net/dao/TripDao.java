package ru.kpfu.itis.gadelev.net.dao;

import java.util.List;

public interface TripDao<T> {
    T get(int car_id);

    List<T> getAll();

    boolean save(T t);
    List<T> getBySearch(String date,String time,String path);
}

package ru.kpfu.itis.gadelev.net.dao;

import java.util.List;

public interface CarDao<T> {
    T get(int driver_id);

    List<T> getAll();

    boolean save(T t);
}

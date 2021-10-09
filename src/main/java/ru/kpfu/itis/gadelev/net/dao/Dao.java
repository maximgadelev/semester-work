package ru.kpfu.itis.gadelev.net.dao;

import java.util.List;

public interface Dao<T> {
    T get(String login);

    List<T> getAll();

    boolean save(T t);
}


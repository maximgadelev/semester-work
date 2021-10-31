package ru.kpfu.itis.gadelev.net.dao;

import java.util.List;

public interface PassengerDao<T> {
    T getByLogin(String login);

    List<T> getAll();

    boolean save(T t);
    T getById(int id);
    void changePhoto(int id, String url);
    void updateRating(int id,double rating);
}


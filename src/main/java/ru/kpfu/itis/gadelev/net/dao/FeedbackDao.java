package ru.kpfu.itis.gadelev.net.dao;

import java.util.List;

public interface FeedbackDao<T> {
    T get(int id);
    List<T> getAll(int id);
    boolean save(T t);
    double getRating(int id);
}

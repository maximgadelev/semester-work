package ru.kpfu.itis.gadelev.net.service;

import ru.kpfu.itis.gadelev.net.dto.DriverDto;
import ru.kpfu.itis.gadelev.net.model.Driver;


import java.util.List;

public interface DriverService<T> {
    DriverDto getById(int id);
DriverDto getByLogin(String login);
    List<DriverDto> getAll();
    void changePhoto(int id,String url);
    boolean save(Driver driver);
    void updateRating(double rating,int id);
}

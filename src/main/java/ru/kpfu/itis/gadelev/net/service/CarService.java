package ru.kpfu.itis.gadelev.net.service;

import ru.kpfu.itis.gadelev.net.dto.CarDto;
import ru.kpfu.itis.gadelev.net.model.Car;


import java.util.List;

public interface CarService<T> {
    CarDto get(int driver_id);

    List<CarDto> getAll();

    boolean save(Car car,int driver_id);
}
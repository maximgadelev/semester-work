package ru.kpfu.itis.gadelev.net.service;

import ru.kpfu.itis.gadelev.net.dto.DriverDto;
import ru.kpfu.itis.gadelev.net.model.Driver;


import java.util.List;

public interface DriverService<T> {
    DriverDto get(int id);

    List<DriverDto> getAll();

    boolean save(Driver driver);
}

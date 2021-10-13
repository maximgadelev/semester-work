package ru.kpfu.itis.gadelev.net.service.impl;

import ru.kpfu.itis.gadelev.net.dao.Dao;
import ru.kpfu.itis.gadelev.net.dao.impl.DriverDaoImpl;
import ru.kpfu.itis.gadelev.net.dao.impl.PassengerDaoImpl;
import ru.kpfu.itis.gadelev.net.dto.DriverDto;
import ru.kpfu.itis.gadelev.net.helper.PasswordHelper;
import ru.kpfu.itis.gadelev.net.model.Driver;
import ru.kpfu.itis.gadelev.net.service.DriverService;

import java.util.List;

public class DriverServiceImpl implements DriverService {
    private final Dao<Driver> dao = new DriverDaoImpl();

    @Override
    public DriverDto get(int id) {
        return null;
    }

    @Override
    public List<DriverDto> getAll() {
        return null;
    }

    @Override
    public boolean save(Driver driver) {
        return dao.save(new Driver(
                driver.getName(),
                driver.getSurname(),
                driver.getLogin(),
                PasswordHelper.encrypt(driver.getPassword()),
                driver.getDateOfBirth()
        ));
    }
}

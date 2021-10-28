package ru.kpfu.itis.gadelev.net.service.impl;

import ru.kpfu.itis.gadelev.net.dao.DriverDao;
import ru.kpfu.itis.gadelev.net.dao.PassengerDao;
import ru.kpfu.itis.gadelev.net.dao.impl.DriverDaoImpl;
import ru.kpfu.itis.gadelev.net.dto.DriverDto;
import ru.kpfu.itis.gadelev.net.helper.PasswordHelper;
import ru.kpfu.itis.gadelev.net.model.Driver;
import ru.kpfu.itis.gadelev.net.service.DriverService;

import java.util.List;

public class DriverServiceImpl implements DriverService {
    private final DriverDao<Driver> driverDao = new DriverDaoImpl();

    @Override
    public DriverDto getById(int id) {
        Driver driver = driverDao.getById(id);
        return new DriverDto(
                driver.getId(),
                driver.getName(),
                driver.getSurname(),
                driver.getLogin(),
                driver.getRating(),
                driver.getDateOfBirth(),
                driver.getProfileImage());
    }

    @Override
    public List<DriverDto> getAll() {
        return null;
    }

    @Override
    public boolean save(Driver driver) {
        return driverDao.save(new Driver(
                driver.getName(),
                driver.getSurname(),
                driver.getLogin(),
                PasswordHelper.encrypt(driver.getPassword()),
                driver.getDateOfBirth()
        ));
    }
@Override
    public void changePhoto(int id, String url) {
        driverDao.changePhoto(id,url);
    }
}

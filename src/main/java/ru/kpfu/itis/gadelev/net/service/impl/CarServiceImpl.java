package ru.kpfu.itis.gadelev.net.service.impl;

import ru.kpfu.itis.gadelev.net.dao.CarDao;
import ru.kpfu.itis.gadelev.net.dao.impl.CarDaoImpl;
import ru.kpfu.itis.gadelev.net.dto.CarDto;
import ru.kpfu.itis.gadelev.net.model.Car;
import ru.kpfu.itis.gadelev.net.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {
    private final CarDao<Car> carDao = new CarDaoImpl();
    @Override
    public CarDto get(int driver_id) {
        Car car = carDao.get(driver_id);
        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getNumber(),
                car.getNumberOfPlaces(),
                car.getModel());
    }

    @Override
    public List<CarDto> getAll() {
        return null;
    }

    @Override
    public boolean save(Car car,int driverId) {
        return carDao.save(new Car(driverId,
                car.getBrand(),
                car.getNumber(),
                car.getNumberOfPlaces(),
                car.getModel()
                ));
    }
}

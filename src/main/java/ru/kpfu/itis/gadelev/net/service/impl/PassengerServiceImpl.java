package ru.kpfu.itis.gadelev.net.service.impl;

import ru.kpfu.itis.gadelev.net.dao.UserDao;
import ru.kpfu.itis.gadelev.net.dao.impl.PassengerUserDaoImpl;
import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.helper.PasswordHelper;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.service.PassengerService;

import java.util.List;
import java.util.stream.Collectors;

public class PassengerServiceImpl implements PassengerService {
    private final UserDao<Passenger> userDao = new PassengerUserDaoImpl();
    @Override
    public PassengerDto get(int id) {
        return null;
    }

    @Override
    public List<PassengerDto> getAll() {
        List<Passenger> passengers = userDao.getAll();
        return passengers.stream()
                .map(p -> new PassengerDto(p.getName(), p.getSurname(), p.getLogin(),p.getRating(),p.getDateOfBirth()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean save(Passenger passenger) {
return userDao.save(new Passenger(
        passenger.getName(),
        passenger.getSurname(),
        passenger.getLogin(),
        PasswordHelper.encrypt(passenger.getPassword()),
        passenger.getDateOfBirth()
));
    }
}

package ru.kpfu.itis.gadelev.net.service.impl;

import ru.kpfu.itis.gadelev.net.dao.PassengerDao;
import ru.kpfu.itis.gadelev.net.dao.impl.PassengerDaoImpl;
import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.helper.PasswordHelper;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.service.PassengerService;

import java.util.List;

public class PassengerServiceImpl implements PassengerService {
    private final PassengerDao<Passenger> passengerDao = new PassengerDaoImpl();
    @Override
    public PassengerDto get(int id) {
        Passenger passenger =(passengerDao.getById(id));
        if(passenger!=null) {
            return new PassengerDto(passenger.getId(),
                    passenger.getName(),
                    passenger.getSurname(),
                    passenger.getLogin(),
                    passenger.getPassword(),
                    passenger.getRating(),
                    passenger.getDateOfBirth()
                    , passenger.getProfileImage());
        }else{
            return null;
        }
    }

    @Override
    public PassengerDto getByLogin(String login) {
        Passenger passenger = passengerDao.getByLogin(login);
        if (passenger != null) {
            return new PassengerDto(passenger.getId(),
                    passenger.getName(),
                    passenger.getSurname(),
                    passenger.getLogin(),
                    passenger.getPassword(),
                    passenger.getRating(),
                    passenger.getDateOfBirth()
                    , passenger.getProfileImage());
        }else{
            return null;
        }
    }

    @Override
    public List<PassengerDto> getAll() {
      return null;
    }

    @Override
    public boolean save(Passenger passenger) {
return passengerDao.save(new Passenger(
        passenger.getName(),
        passenger.getSurname(),
        passenger.getLogin(),
        PasswordHelper.encrypt(passenger.getPassword()),
        passenger.getDateOfBirth(),
        passenger.getProfileImage()
));
    }

    @Override
    public void changePhoto(int id, String url) {
        passengerDao.changePhoto(id,url);
    }

    @Override
    public void updateRating(int id, double rating) {
        passengerDao.updateRating(id,rating);
    }
}

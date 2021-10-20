package ru.kpfu.itis.gadelev.net.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.gadelev.net.dao.CarDao;
import ru.kpfu.itis.gadelev.net.helper.PostgresConnectionHelper;
import ru.kpfu.itis.gadelev.net.model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CarDaoImpl implements CarDao<Car> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PassengerUserDaoImpl.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();
    @Override
    public Car get(int driverId) {
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM cars where driver_id= ?");
            preparedStatement.setInt(1,driverId);
            ResultSet resultSet =preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Car(resultSet.getInt("car_id"),
                        resultSet.getInt("driver_id"),
                        resultSet.getString("brand"),
                        resultSet.getString("number"),
                        resultSet.getInt("number_of_places"),
                        resultSet.getString("model")
                );
            }
            return null;
        }catch (SQLException e){
            LOGGER.warn("Failed get passenger",e);
        }
        return null;
    }

    @Override
    public List<Car> getAll() {
        return null;
    }

    @Override
    public boolean save(Car car) {
        String sql = "INSERT INTO cars (driver_id,brand,number,number_of_places,model) VALUES (?,?,?,?,?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,car.getDriverId());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3,car.getNumber());
            preparedStatement.setInt(4, car.getNumberOfPlaces());
            preparedStatement.setString(5,car.getModel());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new car", throwables);
            return false;
        }
    }
}


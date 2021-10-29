package ru.kpfu.itis.gadelev.net.dao.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.gadelev.net.dao.DriverDao;
import ru.kpfu.itis.gadelev.net.dao.PassengerDao;
import ru.kpfu.itis.gadelev.net.helper.PostgresConnectionHelper;
import ru.kpfu.itis.gadelev.net.model.Driver;
import ru.kpfu.itis.gadelev.net.model.Passenger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DriverDaoImpl implements DriverDao<Driver> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PassengerDaoImpl.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();
    @Override
    public Driver getByLogin(String login) {
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM drivers where login = ?");
            preparedStatement.setString(1,login);
            ResultSet resultSet =preparedStatement.executeQuery();
            if(resultSet.next()){
                Driver driver=new Driver(resultSet.getInt("driver_id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getDouble("rating"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getString("profile_image")
                );
                return driver;
            }
            return null;
        }catch (SQLException e){
            LOGGER.warn("Failed get passenger",e);
        }
        return null;
    }

    @Override
    public List<Driver> getAll() {
        return null;
    }

    @Override
    public boolean save(Driver driver) {
        String sql = "INSERT INTO drivers (name, surname, login, password,date_of_birth) VALUES (?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2,driver.getSurname());
            preparedStatement.setString(3, driver.getLogin());
            preparedStatement.setString(4, driver.getPassword());
            preparedStatement.setString(5,driver.getDateOfBirth());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new driver-user", throwables);
            return false;
        }
    }

    @Override
    public Driver getById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM drivers where driver_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Driver driver = new Driver(
                        resultSet.getInt("driver_id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getDouble("rating"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getString("profile_image")
                );
                return driver;
            }
            return null;
        } catch (SQLException e) {
            LOGGER.warn("Failed get driver", e);
        }
        return null;
    }

    @Override
    public void changePhoto(int id, String url) {
        String sql = "UPDATE drivers SET profile_image = ? WHERE driver_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, url);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to update driver.", throwables);
        }
    }

    @Override
    public void updateRating(double rating,int id) {
        String sql="UPDATE drivers SET rating = ? where driver_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1,rating);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){
            LOGGER.warn("Failed to update rating",sqlException);
        }
    }
}

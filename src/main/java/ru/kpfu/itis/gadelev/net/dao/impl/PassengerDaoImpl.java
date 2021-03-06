package ru.kpfu.itis.gadelev.net.dao.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.gadelev.net.dao.PassengerDao;
import ru.kpfu.itis.gadelev.net.helper.PostgresConnectionHelper;
import ru.kpfu.itis.gadelev.net.model.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PassengerDaoImpl implements PassengerDao<Passenger> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PassengerDaoImpl.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();

    public Passenger getByLogin(String login) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM passengers where login = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Passenger passenger = new Passenger(
                        resultSet.getInt("passenger_id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getDouble("rating"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getString("profile_image")
                );
                return passenger;
            }
            return null;
        } catch (SQLException e) {
            LOGGER.warn("Failed get passenger", e);
        }
        return null;
    }

    public List<Passenger> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM passengers";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Passenger> passengers = new ArrayList<>();

            while (resultSet.next()) {
                Passenger passenger = new Passenger(
                        resultSet.getInt("passenger_id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getDouble("rating"),
                        resultSet.getString("date_of_birth")
                );
                passengers.add(passenger);
            }

            return passengers;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed execute getAll query.", throwables);
            return new ArrayList<>();
        }
    }

    public boolean save(Passenger passenger) {
        String sql = "INSERT INTO passengers (name, surname, login, password,date_of_birth) VALUES (?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setString(2, passenger.getSurname());
            preparedStatement.setString(3, passenger.getLogin());
            preparedStatement.setString(4, passenger.getPassword());
            preparedStatement.setString(5, passenger.getDateOfBirth());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new passenger-user", throwables);
            return false;
        }
    }

    @Override
    public Passenger getById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM passengers where passenger_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Passenger passenger = new Passenger(
                        resultSet.getInt("passenger_id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getDouble("rating"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getString("profile_image")
                );
                return passenger;
            }
            return null;
        } catch (SQLException e) {
            LOGGER.warn("Failed get passenger", e);
        }
        return null;
    }

    @Override
    public void changePhoto(int id, String url) {
        String sql = "UPDATE passengers SET profile_image = ? WHERE passenger_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, url);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to update user.", throwables);
        }
    }

    @Override
    public void updateRating(int id,double rating) {
        String sql="UPDATE passengers SET rating = ? where passenger_id = ?";
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


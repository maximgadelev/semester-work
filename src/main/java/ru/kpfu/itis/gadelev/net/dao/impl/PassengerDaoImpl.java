package ru.kpfu.itis.gadelev.net.dao.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.gadelev.net.dao.Dao;
import ru.kpfu.itis.gadelev.net.helper.PostgresConnectionHelper;
import ru.kpfu.itis.gadelev.net.model.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PassengerDaoImpl implements Dao<Passenger> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PassengerDaoImpl.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();

    public Passenger get(String  login) {
      try{
          PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM passengers where login = ?");
preparedStatement.setString(1,login);
ResultSet resultSet =preparedStatement.executeQuery();
if(resultSet.next()){
    Passenger passenger=new Passenger(resultSet.getInt("passenger_id"),
            resultSet.getString("name"),
            resultSet.getString("surname"),
            resultSet.getString("login"),
            resultSet.getString("password"),
            resultSet.getDouble("rating"),
            resultSet.getString("date_of_birth")
    );
    return passenger;
}
return null;
      }catch (SQLException e){
          LOGGER.warn("Failed get passenger",e);
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
        String sql = "INSERT INTO passengers (name, surname, login, password,rating,date_of_birth) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setString(2, passenger.getSurname());
            preparedStatement.setString(3, passenger.getLogin());
            preparedStatement.setString(4, passenger.getPassword());
            preparedStatement.setDouble(5,passenger.getRating());
            preparedStatement.setString(6,passenger.getDateOfBirth());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new user.", throwables);
            return false;
        }
    }
    }


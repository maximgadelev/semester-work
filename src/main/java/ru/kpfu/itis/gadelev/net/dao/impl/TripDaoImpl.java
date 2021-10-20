package ru.kpfu.itis.gadelev.net.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.gadelev.net.dao.TripDao;
import ru.kpfu.itis.gadelev.net.helper.PostgresConnectionHelper;
import ru.kpfu.itis.gadelev.net.model.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class TripDaoImpl implements TripDao<Trip> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PassengerDaoImpl.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();
    @Override
    public Trip get(int car_id) {
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM trips where car_id= ?");
            preparedStatement.setInt(1,car_id);
            ResultSet resultSet =preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Trip(
                        resultSet.getInt("trip_id"),
                        resultSet.getInt("admin_id"),
                        resultSet.getInt("car_id"),
                        resultSet.getString("date"),
                        resultSet.getInt("price"),
                        resultSet.getString("path"),
                        resultSet.getString("time")
                );
            }
            return null;
        }catch (SQLException e){
            LOGGER.warn("Failed get passenger",e);
        }
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public boolean save(Trip trip) {
        String sql = "INSERT INTO trips (admin_id,car_id,price,path,date,time) VALUES (?,?,?,?,?,?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,trip.getAdmin_id());
            preparedStatement.setInt(2, trip.getCar_id());
            preparedStatement.setInt(3,trip.getPrice());
            preparedStatement.setString(4, trip.getPath());
            preparedStatement.setString(5,trip.getDate());
            preparedStatement.setString(6,trip.getTime());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new trip", throwables);
            return false;
        }
    }
}

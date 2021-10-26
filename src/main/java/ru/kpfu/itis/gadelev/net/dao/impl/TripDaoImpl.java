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
import java.util.ArrayList;
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
                        resultSet.getString("time"),
                        resultSet.getInt("not_free_places"),
                        resultSet.getInt("free_places"),
                        resultSet.getString("status")
                );
            }
            return null;
        }catch (SQLException e){
            LOGGER.warn("Failed get trip",e);
        }
        return null;
    }

    @Override
    public Trip getById(int trip_id) {
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM trips where trip_id= ?");
            preparedStatement.setInt(1,trip_id);
            ResultSet resultSet =preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Trip(
                        resultSet.getInt("trip_id"),
                        resultSet.getInt("admin_id"),
                        resultSet.getInt("car_id"),
                        resultSet.getString("date"),
                        resultSet.getInt("price"),
                        resultSet.getString("path"),
                        resultSet.getString("time"),
                        resultSet.getInt("not_free_places"),
                        resultSet.getInt("free_places"),
                        resultSet.getString("status")
                );
            }
            return null;
        }catch (SQLException e){
            LOGGER.warn("Failed get trip",e);
        }
        return null;
    }

    @Override
    public void changeFreePlaces(int trip_id,int places) {
        String sql = "UPDATE trips SET free_places = ?,not_free_places = ?  WHERE trip_id = ?";
Trip trip = getById(trip_id);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, trip.getFreePlaces()-places);
            preparedStatement.setInt(2, trip.getNotFreePlaces()+places);
            preparedStatement.setInt(3,trip.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to update trip.", throwables);
        }
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public boolean save(Trip trip) {
        String sql = "INSERT INTO trips (admin_id,car_id,price,path,date,time,not_free_places,free_places,status) VALUES (?,?,?,?,?,?,?,?,?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,trip.getAdmin_id());
            preparedStatement.setInt(2, trip.getCar_id());
            preparedStatement.setInt(3,trip.getPrice());
            preparedStatement.setString(4, trip.getPath());
            preparedStatement.setString(5,trip.getDate());
            preparedStatement.setString(6,trip.getTime());
            preparedStatement.setInt(7,trip.getNotFreePlaces());
            preparedStatement.setInt(8,trip.getFreePlaces());
            preparedStatement.setString(9,trip.getStatus());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new trip", throwables);
            return false;
        }
    }

    @Override
    public List<Trip> getBySearch(String date, String time, String path,int freePlaces) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trips where date = ? and time = ? and path =? and ?<=free_places and status='Активна' ");
            preparedStatement.setString(1,date);
            preparedStatement.setString(2,time);
            preparedStatement.setString(3,path);
            preparedStatement.setInt(4,freePlaces);
            List<Trip> trips = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Trip trip= new  Trip(
                        resultSet.getInt("trip_id"),
                        resultSet.getInt("admin_id"),
                        resultSet.getInt("car_id"),
                        resultSet.getString("date"),
                        resultSet.getInt("price"),
                        resultSet.getString("path"),
                        resultSet.getString("time"),
                        resultSet.getInt("not_free_places"),
                        resultSet.getInt("free_places"),
                        resultSet.getString("status")
                );
                trips.add(trip);
            }
            return trips;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to find trips", throwables);
            return new ArrayList<>();
        }
    }
}

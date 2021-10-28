package ru.kpfu.itis.gadelev.net.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.gadelev.net.dao.PassengerTripsDao;
import ru.kpfu.itis.gadelev.net.helper.PostgresConnectionHelper;
import ru.kpfu.itis.gadelev.net.model.Driver;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.model.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerTripsDaoImpl implements PassengerTripsDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(PassengerTripsDao.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public List<Passenger> getPassengerByTrip(int trip_id) {
        String sql = "select distinct *from (select *from passengers_trip inner join passengers p on p.passenger_id = passengers_trip.passenger_id) as passenger_list where trip_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, trip_id);
            List<Passenger> passengers = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
                passengers.add(passenger);
            }
            return passengers;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to select passengers");
            return new ArrayList<>();
        }
    }

    @Override
    public List<Trip> getPassengerTripsByStatus(int passenger_id, String status) {
        String sql = "select distinct *from (select *from  passengers_trip inner join trips t on passengers_trip.trip_id = t.trip_id where passenger_id = ? order by status) as trips where status = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, passenger_id);
            preparedStatement.setString(2, status);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Trip> trips = new ArrayList<>();
            while (resultSet.next()) {
                Trip trip = new Trip(
                        resultSet.getInt("trip_id"),
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
            LOGGER.warn("Failed to select trips");
            return new ArrayList<>();
        }
    }

    @Override
    public boolean savePassengerTrip(int passenger_id, int trip_id) {
        String sql = "INSERT INTO passengers_trip (passenger_id,trip_id) VALUES (?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, passenger_id);
            preparedStatement.setInt(2, trip_id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new trip for users", throwables);
            return false;
        }
    }

    @Override
    public Driver getDriverBytrip(int trip_id) {
        String sql = "select *from(select *from passengers_trip inner join trips t on t.trip_id = passengers_trip.trip_id where t.trip_id = ?) as trips_by_passenger inner join drivers d on trips_by_passenger.car_id=d.driver_id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, trip_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Driver(
                        resultSet.getInt("driver_id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getDouble("rating"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getString("profile_image")
                );
            }
            return null;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to select driver", throwables);
        }
        return null;
    }
}

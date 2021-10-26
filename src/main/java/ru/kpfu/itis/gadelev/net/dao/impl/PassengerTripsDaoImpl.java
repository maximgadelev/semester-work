package ru.kpfu.itis.gadelev.net.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.gadelev.net.dao.PassengerTripsDao;
import ru.kpfu.itis.gadelev.net.helper.PostgresConnectionHelper;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.model.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PassengerTripsDaoImpl implements PassengerTripsDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(PassengerTripsDao.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();
    @Override
    public List getPassengerByTrip(int trip_id) {
        return null;
    }

    @Override
    public List getPassengerTrips(int passenger_id) {
        return null;
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
    }

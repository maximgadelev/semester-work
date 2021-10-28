package ru.kpfu.itis.gadelev.net.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.gadelev.net.dao.FeedbackDao;
import ru.kpfu.itis.gadelev.net.helper.PostgresConnectionHelper;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.model.PassengerFeedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerFeedbackDaoImpl implements FeedbackDao<PassengerFeedback> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PassengerFeedbackDaoImpl.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();
    @Override
    public PassengerFeedback get(int id) {
        return null;
    }

    @Override
    public List<PassengerFeedback> getAll(int id) {
        String sql = "SELECT*FROM passengers_feedback where passenger_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            List<PassengerFeedback> passengersFeedbacks = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                PassengerFeedback passengerFeedback = new PassengerFeedback(
                        resultSet.getInt("feedback_id"),
                        resultSet.getInt("passenger_id"),
                        resultSet.getString("text"),
                        resultSet.getInt("from_driver_id")
                );
                passengersFeedbacks.add(passengerFeedback);
            }
            return passengersFeedbacks;
        }catch (SQLException throwables){
            LOGGER.warn("Failed to select passengersFeedback");
            return new ArrayList<>();
        }
    }

    @Override
    public boolean save(PassengerFeedback passengerFeedback) {
        String sql = "INSERT INTO passengers_feedback (passenger_id,text,from_driver_id) VALUES (?,?,?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,passengerFeedback.getPassenger_id());
            preparedStatement.setString(2,passengerFeedback.getText());
            preparedStatement.setInt(3,passengerFeedback.getDriver_id());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new feedBack", throwables);
            return false;
        }
    }
    }

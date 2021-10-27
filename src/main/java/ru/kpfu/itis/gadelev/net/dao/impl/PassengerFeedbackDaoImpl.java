package ru.kpfu.itis.gadelev.net.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.gadelev.net.dao.FeedbackDao;
import ru.kpfu.itis.gadelev.net.helper.PostgresConnectionHelper;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.model.PassengerFeedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public boolean save(PassengerFeedback passengerFeedback) {
        String sql = "INSERT INTO passengers_feedback (feedback_id,passenger_id,text) VALUES (?,?,?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, passengerFeedback.getId());
            preparedStatement.setInt(2,passengerFeedback.getPassenger_id());
            preparedStatement.setString(3,passengerFeedback.getText());
            return true;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new feedBack", throwables);
            return false;
        }
    }
    }

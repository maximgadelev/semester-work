package ru.kpfu.itis.gadelev.net.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.gadelev.net.dao.FeedbackDao;
import ru.kpfu.itis.gadelev.net.helper.PostgresConnectionHelper;
import ru.kpfu.itis.gadelev.net.model.DriverFeedback;
import ru.kpfu.itis.gadelev.net.model.PassengerFeedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverFeedbackDaoImpl implements FeedbackDao<DriverFeedback> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverFeedbackDaoImpl.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();
    @Override
    public DriverFeedback get(int id) {
        return null;
    }

    @Override
    public List<DriverFeedback>getAll(int id) {
        String sql = "SELECT*FROM drivers_feedback where driver_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            List<DriverFeedback> driverFeedbacks = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                DriverFeedback driverFeedback = new DriverFeedback(
                        resultSet.getInt("feedback_id"),
                        resultSet.getInt("driver_id"),
                        resultSet.getString("text"),
                        resultSet.getInt("from_passenger_id")
                );
                driverFeedbacks.add(driverFeedback);
            }
            return driverFeedbacks;
        }catch (SQLException throwables){
            LOGGER.warn("Failed to select driverFeedback");
            return new ArrayList<>();
        }
    }

    @Override
    public boolean save(DriverFeedback driverFeedback) {
        String sql = "INSERT INTO drivers_feedback (driver_id,text,from_passenger_id) VALUES (?,?,?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,driverFeedback.getDriver_id());
            preparedStatement.setString(2,driverFeedback.getText());
            preparedStatement.setInt(3,driverFeedback.getPassenger_id());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new feedBack", throwables);
            return false;
        }
    }
}

package ru.kpfu.itis.gadelev.net.service.impl;

import ru.kpfu.itis.gadelev.net.dao.FeedbackDao;
import ru.kpfu.itis.gadelev.net.dao.impl.DriverFeedbackDaoImpl;
import ru.kpfu.itis.gadelev.net.dto.DriverFeedbackDto;
import ru.kpfu.itis.gadelev.net.dto.PassengersFeedbackDto;
import ru.kpfu.itis.gadelev.net.model.DriverFeedback;
import ru.kpfu.itis.gadelev.net.service.DriversFeedbackService;

import java.util.List;
import java.util.stream.Collectors;

public class DriversFeedbackServiceImpl implements DriversFeedbackService {
    FeedbackDao feedbackDao = new DriverFeedbackDaoImpl();
    @Override
    public DriverFeedbackDto get(int id) {
        return null;
    }

    @Override
    public List<DriverFeedbackDto> getAll(int id) {
       List<DriverFeedback> driverFeedbacks = feedbackDao.getAll(id);
       return driverFeedbacks.stream().map(driverFeedback -> new DriverFeedbackDto(
               driverFeedback.getId(),
               driverFeedback.getDriver_id(),
               driverFeedback.getText(),
               driverFeedback.getPassenger_id(),
               driverFeedback.getAdded_rating()
       )).collect(Collectors.toList());
    }

    @Override
    public boolean save(DriverFeedback driverFeedback) {
        return feedbackDao.save(new DriverFeedback(driverFeedback.getId(),
                driverFeedback.getDriver_id(),
                driverFeedback.getText(),
                driverFeedback.getPassenger_id(),
                driverFeedback.getAdded_rating()));
    }

    @Override
    public double getRating(int id) {
        return feedbackDao.getRating(id);
    }
}

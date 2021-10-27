package ru.kpfu.itis.gadelev.net.service.impl;

import ru.kpfu.itis.gadelev.net.dao.FeedbackDao;
import ru.kpfu.itis.gadelev.net.dao.impl.PassengerFeedbackDaoImpl;
import ru.kpfu.itis.gadelev.net.dto.PassengersFeedbackDto;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.model.PassengerFeedback;
import ru.kpfu.itis.gadelev.net.service.PassengersFeedbackService;

import java.util.List;

public class PassengersFeedbackServiceImpl implements PassengersFeedbackService {
    FeedbackDao feedbackDao = new PassengerFeedbackDaoImpl();
    @Override
    public PassengersFeedbackDto get(int id) {
        return null;
    }

    @Override
    public List<PassengersFeedbackDto> getAll(int id) {
        return null;
    }

    @Override
    public boolean save(PassengerFeedback passengersFeedback) {
        return feedbackDao.save(new PassengerFeedback(passengersFeedback.getId(),
                passengersFeedback.getPassenger_id(),
                passengersFeedback.getText(),
                passengersFeedback.getDriver_id())
        );
    }
}

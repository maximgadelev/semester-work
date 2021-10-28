package ru.kpfu.itis.gadelev.net.service.impl;

import ru.kpfu.itis.gadelev.net.dao.FeedbackDao;
import ru.kpfu.itis.gadelev.net.dao.impl.PassengerFeedbackDaoImpl;
import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.dto.PassengersFeedbackDto;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.model.PassengerFeedback;
import ru.kpfu.itis.gadelev.net.service.PassengersFeedbackService;

import java.util.List;
import java.util.stream.Collectors;

public class PassengersFeedbackServiceImpl implements PassengersFeedbackService {
    FeedbackDao feedbackDao = new PassengerFeedbackDaoImpl();
    @Override
    public PassengersFeedbackDto get(int id) {
        return null;
    }

    @Override
    public List<PassengersFeedbackDto> getAll(int id) {
        List<PassengerFeedback> passengerFeedbacks = feedbackDao.getAll(id);
        return passengerFeedbacks.stream().map(passengerFeedback -> new PassengersFeedbackDto(
                passengerFeedback.getId(),
                passengerFeedback.getPassenger_id(),
                passengerFeedback.getText(),
                passengerFeedback.getDriver_id()
        )).collect(Collectors.toList());
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

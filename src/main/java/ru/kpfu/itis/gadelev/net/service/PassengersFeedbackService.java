package ru.kpfu.itis.gadelev.net.service;

import ru.kpfu.itis.gadelev.net.dto.PassengersFeedbackDto;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.model.PassengerFeedback;

import java.util.List;

public interface PassengersFeedbackService{
    PassengersFeedbackDto get(int id);
    List<PassengersFeedbackDto> getAll(int id);
    boolean save(PassengerFeedback passengerFeedback);
    double getRating(int id);
}

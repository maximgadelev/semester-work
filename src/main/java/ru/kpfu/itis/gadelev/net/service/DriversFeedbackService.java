package ru.kpfu.itis.gadelev.net.service;
import ru.kpfu.itis.gadelev.net.dto.DriverFeedbackDto;
import ru.kpfu.itis.gadelev.net.model.DriverFeedback;

import java.util.List;

public interface DriversFeedbackService {
    DriverFeedbackDto get(int id);
    List<DriverFeedbackDto> getAll(int id);
    boolean save(DriverFeedback driverFeedback);
}

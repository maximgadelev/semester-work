package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dto.DriverDto;
import ru.kpfu.itis.gadelev.net.dto.PassengersFeedbackDto;
import ru.kpfu.itis.gadelev.net.service.DriverService;
import ru.kpfu.itis.gadelev.net.service.PassengersFeedbackService;
import ru.kpfu.itis.gadelev.net.service.impl.DriverServiceImpl;
import ru.kpfu.itis.gadelev.net.service.impl.PassengersFeedbackServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/passengersFeedback")
public class PassengersFeedbackServlet extends HttpServlet {
    PassengersFeedbackService passengersFeedbackService = new PassengersFeedbackServiceImpl();
    DriverService driverService = new DriverServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        int passenger_id = 0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("passenger_id")) {
                passenger_id = Integer.parseInt(cookie.getValue());
            }
        }
        List<DriverDto> driverDtos = new ArrayList<>();
            List<PassengersFeedbackDto> feedbackDtoList = passengersFeedbackService.getAll(passenger_id);
            for (PassengersFeedbackDto feedback:feedbackDtoList
                 ) {

                driverDtos.add(driverService.getById(feedback.getDriver_id()));
            }
        for (int i = 0; i <driverDtos.size() ; i++) {
            for (int j = 0; j <driverDtos.size() ; j++) {
                if (driverDtos.get(i).getId() == driverDtos.get(j).getId()) {
                    driverDtos.remove(i);
                }
            }
        }

        req.setAttribute("drivers",driverDtos);
            req.setAttribute("passengersFeedback", feedbackDtoList);
            req.getRequestDispatcher("passengersFeedback.ftl").forward(req, resp);

    }
}

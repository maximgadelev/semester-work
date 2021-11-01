package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dto.DriverDto;
import ru.kpfu.itis.gadelev.net.dto.DriverFeedbackDto;
import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.model.DriverFeedback;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.service.DriversFeedbackService;
import ru.kpfu.itis.gadelev.net.service.PassengerService;
import ru.kpfu.itis.gadelev.net.service.PassengersFeedbackService;
import ru.kpfu.itis.gadelev.net.service.impl.DriversFeedbackServiceImpl;
import ru.kpfu.itis.gadelev.net.service.impl.PassengerServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(urlPatterns = "/driversFeedback")
public class DriverFeedbackServlet extends HttpServlet {
  DriversFeedbackService driversFeedbackService = new DriversFeedbackServiceImpl();
  PassengerService passengerService = new PassengerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DriverDto driverDto = (DriverDto) req.getSession().getAttribute("driver");
        int driver_id =driverDto.getId();

     List<PassengerDto> passengetDtos =new ArrayList<>();
        List<DriverFeedbackDto> driverFeedbackList = driversFeedbackService.getAll(driver_id);
        for (DriverFeedbackDto driverFeedback:driverFeedbackList
             ) {
            passengetDtos.add(passengerService.get(driverFeedback.getPassenger_id()));
        }
        for (int i = 0; i < passengetDtos.size(); i++) {
            for (int j = 0; j <passengetDtos.size(); j++) {
                if (passengetDtos.get(i).getId() == passengetDtos.get(j).getId()) {
                    passengetDtos.remove(i);
                }
            }
        }
        req.setAttribute("passengers",passengetDtos);
        req.setAttribute("driversFeedback",driverFeedbackList);
        req.getRequestDispatcher("DriversFeedback.ftl").forward(req,resp);
    }
}

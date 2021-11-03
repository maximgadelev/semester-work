package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.dto.TripDto;
import ru.kpfu.itis.gadelev.net.service.PassengersTripService;
import ru.kpfu.itis.gadelev.net.service.impl.PassengersTripServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/activePassengerTrips")
public class PassengerActiveTripsServlet extends HttpServlet {
    PassengersTripService passengersTripService = new PassengersTripServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PassengerDto passengerDto = (PassengerDto)req.getSession().getAttribute("passenger");
        int passenger_id = passengerDto.getId();

       List<TripDto> tripDtoList= passengersTripService.getPassengerTripsByStatus(passenger_id,"Активна");
        req.setAttribute("passengersActiveTrips",tripDtoList);
        req.getRequestDispatcher("ActivePassengerTrips.ftl").forward(req,resp);
    }
}

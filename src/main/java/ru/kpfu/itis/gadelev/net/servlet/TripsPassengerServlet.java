package ru.kpfu.itis.gadelev.net.servlet;
import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.service.PassengersTripService;
import ru.kpfu.itis.gadelev.net.service.impl.PassengersTripServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/tripsPassenger")
public class TripsPassengerServlet extends HttpServlet {
    PassengersTripService passengersTripService = new PassengersTripServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int tripId=Integer.parseInt(req.getParameter("tripId"));
         List<PassengerDto> passengerDtoList = passengersTripService.getPassengerByTrip(tripId);
         req.setAttribute("tripsPassengers",passengerDtoList);
//         int passengerId=Integer.parseInt(req.getParameter("pId"));
//         req.setAttribute("neededPassenger",passengerDtoList.get(Integer.parseInt(req.getParameter("pId"))));;
        req.getRequestDispatcher("tripsPassenger.ftl").forward(req,resp);
        }
    }


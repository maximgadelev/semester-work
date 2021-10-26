package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dto.TripDto;
import ru.kpfu.itis.gadelev.net.service.PassengersTripService;
import ru.kpfu.itis.gadelev.net.service.TripService;
import ru.kpfu.itis.gadelev.net.service.impl.PassengersTripServiceImpl;
import ru.kpfu.itis.gadelev.net.service.impl.TripServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/tripsBySearch")
public class TripsBySearchServlet extends HttpServlet {
    PassengersTripService passengersTripService =new PassengersTripServiceImpl();
    TripService tripService = new TripServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        req.setAttribute("trips", httpSession.getAttribute("trips"));
        Cookie[] cookies = req.getCookies();
        int userNumberOfPlaces = 0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("places")) {
                userNumberOfPlaces = Integer.parseInt(cookie.getValue());
            }
        }
        req.setAttribute("places", userNumberOfPlaces);
        req.getRequestDispatcher("TripsBySearch.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        int passenger_id=0;
        int userNumberOfPlaces = 0;
        for(Cookie cookie:cookies) {
            if (cookie.getName().equals("passenger_id")) {
                passenger_id = Integer.parseInt(cookie.getValue());
            }
            if(cookie.getName().equals("places")){
                userNumberOfPlaces=Integer.parseInt(cookie.getValue());
            }
        }

            if(passengersTripService.savePassengerTrip(passenger_id,(Integer.parseInt(req.getParameter("tripId"))))){
                tripService.changeFreePlaces(Integer.parseInt(req.getParameter("tripId")),userNumberOfPlaces);
                resp.sendRedirect("/passenger");
            }
        }
    }


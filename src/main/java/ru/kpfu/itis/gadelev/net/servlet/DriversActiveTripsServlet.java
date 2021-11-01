package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dao.TripDao;
import ru.kpfu.itis.gadelev.net.dao.impl.TripDaoImpl;
import ru.kpfu.itis.gadelev.net.dto.DriverDto;
import ru.kpfu.itis.gadelev.net.dto.TripDto;
import ru.kpfu.itis.gadelev.net.model.Car;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.model.Trip;
import ru.kpfu.itis.gadelev.net.service.CarService;
import ru.kpfu.itis.gadelev.net.service.PassengersTripService;
import ru.kpfu.itis.gadelev.net.service.TripService;
import ru.kpfu.itis.gadelev.net.service.impl.CarServiceImpl;
import ru.kpfu.itis.gadelev.net.service.impl.PassengersTripServiceImpl;
import ru.kpfu.itis.gadelev.net.service.impl.TripServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns ="/driverActiveTrips")
public class DriversActiveTripsServlet extends HttpServlet {
    CarService<Car> carService = new CarServiceImpl();
    TripService tripService = new TripServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        DriverDto driverDto = (DriverDto) req.getSession().getAttribute("driver");
        int driver_id =driverDto.getId();
        int car_id = 0;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("car_id")) {
                car_id = Integer.parseInt(cookie.getValue());
            }
        }

        List<TripDto> tripDtoList = tripService.getByDriverIdAndStatus(driver_id, "Активна");
        req.setAttribute("driverActiveTrips", tripDtoList);
        if (car_id == 0) {
            req.getRequestDispatcher("ActiveDriverTrips.ftl").forward(req, resp);
        } else {
            req.setAttribute("car", carService.get(driver_id));
            req.getRequestDispatcher("ActiveDriverTrips.ftl").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        tripService.changeStatus(Integer.parseInt(req.getParameter("tripId")));
        resp.sendRedirect("/driverActiveTrips");

    }
}

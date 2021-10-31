package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dto.TripDto;
import ru.kpfu.itis.gadelev.net.model.Car;
import ru.kpfu.itis.gadelev.net.service.CarService;
import ru.kpfu.itis.gadelev.net.service.TripService;
import ru.kpfu.itis.gadelev.net.service.impl.CarServiceImpl;
import ru.kpfu.itis.gadelev.net.service.impl.TripServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = "/driverEndTrips")
public class DriverEndTripsServlet extends HttpServlet {
    CarService<Car> carService = new CarServiceImpl();
    TripService tripService = new TripServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        int driver_id = 0;
        int car_id = 0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("driver_id")) {
                driver_id = Integer.parseInt(cookie.getValue());
            }
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("car_id")) {
                car_id = Integer.parseInt(cookie.getValue());
            }
        }
        List<TripDto> tripDtoList = tripService.getByDriverIdAndStatus(driver_id, "Завершена");
        if (car_id == 0) {
            req.setAttribute("driverEndTrips", tripDtoList);
            req.setAttribute("car", carService.get(driver_id));
            req.getRequestDispatcher("EndDriverTrips.ftl").forward(req, resp);
        } else {
            req.getRequestDispatcher("EndDriverTrips.ftl").forward(req, resp);
        }
    }
}

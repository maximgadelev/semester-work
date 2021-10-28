package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dto.CarDto;
import ru.kpfu.itis.gadelev.net.dto.DriverDto;
import ru.kpfu.itis.gadelev.net.service.CarService;
import ru.kpfu.itis.gadelev.net.service.PassengersTripService;
import ru.kpfu.itis.gadelev.net.service.impl.CarServiceImpl;
import ru.kpfu.itis.gadelev.net.service.impl.PassengersTripServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/driversTrip")
public class DriversTripServlet  extends HttpServlet {
    PassengersTripService passengersTripService = new PassengersTripServiceImpl();
    CarService carService = new CarServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DriverDto driverDto=passengersTripService.getDriverByTrip(Integer.parseInt(req.getParameter("id_trip")));
        req.setAttribute("tripDriver",driverDto);
        CarDto carDto = carService.get(driverDto.getId());
        req.setAttribute("driverCar",carDto);
        req.getRequestDispatcher("driversTrip.ftl").forward(req,resp);

    }
}

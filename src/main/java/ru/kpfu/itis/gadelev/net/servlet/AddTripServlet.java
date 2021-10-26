package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dao.CarDao;
import ru.kpfu.itis.gadelev.net.dao.impl.CarDaoImpl;
import ru.kpfu.itis.gadelev.net.model.Car;
import ru.kpfu.itis.gadelev.net.model.Trip;
import ru.kpfu.itis.gadelev.net.service.CarService;
import ru.kpfu.itis.gadelev.net.service.TripService;
import ru.kpfu.itis.gadelev.net.service.impl.CarServiceImpl;
import ru.kpfu.itis.gadelev.net.service.impl.TripServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addTrip")
public class AddTripServlet  extends HttpServlet {
    CarDao<Car> carDao = new CarDaoImpl();
    TripService tripService = new TripServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addTrip.ftl").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        int driver_id=0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("driver_id")) {
                driver_id = Integer.parseInt(cookie.getValue());
            }
        }
        Car driverCar = carDao.get(driver_id);

      if(tripService.save(new Trip(1,driverCar.getId(),req.getParameter("date"),Integer.parseInt(req.getParameter("price")),req.getParameter("path"),req.getParameter("time"),driverCar.getNumberOfPlaces()))){
          resp.sendRedirect("/driver");
      }
    }
}

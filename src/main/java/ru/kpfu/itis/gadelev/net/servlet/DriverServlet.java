package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dao.CarDao;
import ru.kpfu.itis.gadelev.net.dao.TripDao;
import ru.kpfu.itis.gadelev.net.dao.impl.CarDaoImpl;
import ru.kpfu.itis.gadelev.net.dao.impl.TripDaoImpl;
import ru.kpfu.itis.gadelev.net.model.Car;
import ru.kpfu.itis.gadelev.net.model.Trip;
import ru.kpfu.itis.gadelev.net.service.CarService;
import ru.kpfu.itis.gadelev.net.service.impl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/driver")
public class DriverServlet extends HttpServlet {
    CarDao<Car> carDao = new CarDaoImpl();
    TripDao<Trip> tripDao=new TripDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        int driver_id = 0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("id")) {
                driver_id = Integer.parseInt(cookie.getValue());
            }
        }
            Car driverCar = carDao.get(driver_id);
            req.setAttribute("car", driverCar);
            HttpSession httpSession = req.getSession();
            req.setAttribute("trip",tripDao.get(driverCar.getId()));
            req.setAttribute("driver", httpSession.getAttribute("driver"));
            req.getRequestDispatcher("driver.ftl").forward(req, resp);


        }
}

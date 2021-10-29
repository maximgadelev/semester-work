package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dao.CarDao;
import ru.kpfu.itis.gadelev.net.dao.TripDao;
import ru.kpfu.itis.gadelev.net.dao.impl.CarDaoImpl;
import ru.kpfu.itis.gadelev.net.dao.impl.TripDaoImpl;
import ru.kpfu.itis.gadelev.net.dto.CarDto;
import ru.kpfu.itis.gadelev.net.dto.DriverDto;
import ru.kpfu.itis.gadelev.net.model.Car;
import ru.kpfu.itis.gadelev.net.model.Driver;
import ru.kpfu.itis.gadelev.net.model.Trip;
import ru.kpfu.itis.gadelev.net.service.CarService;
import ru.kpfu.itis.gadelev.net.service.DriverService;
import ru.kpfu.itis.gadelev.net.service.DriversFeedbackService;
import ru.kpfu.itis.gadelev.net.service.impl.CarServiceImpl;
import ru.kpfu.itis.gadelev.net.service.impl.DriverServiceImpl;
import ru.kpfu.itis.gadelev.net.service.impl.DriversFeedbackServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/driver")
public class DriverServlet extends HttpServlet {
    CarService carService = new CarServiceImpl();
    DriversFeedbackService driversFeedbackService= new DriversFeedbackServiceImpl();
    DriverService driverService = new DriverServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        int driver_id = 0;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("driver_id")) {
                driver_id = Integer.parseInt(cookie.getValue());
            }
        }
        HttpSession httpSession = req.getSession();
        CarDto carDto = carService.get(driver_id);
            httpSession.setAttribute("car", carDto);
            req.setAttribute("driver", httpSession.getAttribute("driver"));
            req.getRequestDispatcher("driver.ftl").forward(req, resp);

}
}

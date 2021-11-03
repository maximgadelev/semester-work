package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dao.CarDao;
import ru.kpfu.itis.gadelev.net.dao.TripDao;
import ru.kpfu.itis.gadelev.net.dao.impl.CarDaoImpl;
import ru.kpfu.itis.gadelev.net.dao.impl.TripDaoImpl;
import ru.kpfu.itis.gadelev.net.dto.CarDto;
import ru.kpfu.itis.gadelev.net.dto.DriverDto;
import ru.kpfu.itis.gadelev.net.helper.CookieHelper;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CookieHelper.checkCookie(req);
        int driver_id = 0;
        DriverDto driverDto=(DriverDto)req.getSession().getAttribute("driver");
        driver_id=driverDto.getId();
        HttpSession httpSession = req.getSession();
        try {
            CarDto carDto = carService.get(driver_id);
            httpSession.setAttribute("car", carDto);
            resp.addCookie(new Cookie("car_id",String.valueOf(carDto.getId())));
            req.setAttribute("driver", httpSession.getAttribute("driver"));
            req.getRequestDispatcher("driver.ftl").forward(req, resp);
        }catch (NullPointerException e){
            req.setAttribute("driver", httpSession.getAttribute("driver"));
            req.getRequestDispatcher("driver.ftl").forward(req, resp);
        }

}
}

package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dto.DriverDto;
import ru.kpfu.itis.gadelev.net.model.Car;
import ru.kpfu.itis.gadelev.net.service.CarService;
import ru.kpfu.itis.gadelev.net.service.impl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCar")
public class AddCarServlet extends HttpServlet {
    CarService carService = new CarServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int driver_id=0;
        DriverDto driverDto=(DriverDto)req.getSession().getAttribute("driver");
        driver_id=driverDto.getId();
        carService.save(new Car(req.getParameter("brand"),req.getParameter("number"),Integer.parseInt(req.getParameter("numberOfPlaces")),req.getParameter("model")),driver_id);
        resp.sendRedirect("/driver");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addCar.ftl").forward(req,resp);
    }
}

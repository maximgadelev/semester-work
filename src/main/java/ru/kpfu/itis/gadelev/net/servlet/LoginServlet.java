package ru.kpfu.itis.gadelev.net.servlet;


import ru.kpfu.itis.gadelev.net.dao.DriverDao;
import ru.kpfu.itis.gadelev.net.dao.PassengerDao;
import ru.kpfu.itis.gadelev.net.dao.impl.DriverDaoImpl;
import ru.kpfu.itis.gadelev.net.dao.impl.PassengerDaoImpl;
import ru.kpfu.itis.gadelev.net.helper.PasswordHelper;
import ru.kpfu.itis.gadelev.net.model.Driver;
import ru.kpfu.itis.gadelev.net.model.Passenger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
private final PassengerDao<Passenger> passengerPassengerDao = new PassengerDaoImpl();
private final DriverDao<Driver> driverDao = new DriverDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = PasswordHelper.encrypt(req.getParameter("password"));
            Passenger passenger = passengerPassengerDao.getByLogin(login);
            if(passenger!=null) {
                if (password.equals(passenger.getPassword())) {
                    req.getSession().setAttribute("passenger", passenger);
                    resp.addCookie(new Cookie("passenger_id",String.valueOf(passenger.getId())));
                    resp.sendRedirect("/passenger");
                }else{
                    resp.sendRedirect("/login");
                }
            }else {
                Driver driver = driverDao.getByLogin(login);
                if (driver != null) {
                    if (password.equals(driver.getPassword())) {
                        req.getSession().setAttribute("driver", driver);
                        resp.addCookie(new Cookie("driver_id", String.valueOf(driver.getId())));
                        resp.sendRedirect("/driver");
                    } else {
                        resp.sendRedirect("/login");
                    }
                } else {
                    resp.sendRedirect("/login");
                }
            }
    }
}

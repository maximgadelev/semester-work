package ru.kpfu.itis.gadelev.net.servlet;


import ru.kpfu.itis.gadelev.net.dao.DriverDao;
import ru.kpfu.itis.gadelev.net.dao.PassengerDao;
import ru.kpfu.itis.gadelev.net.dao.impl.DriverDaoImpl;
import ru.kpfu.itis.gadelev.net.dao.impl.PassengerDaoImpl;
import ru.kpfu.itis.gadelev.net.dto.DriverDto;
import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.helper.PasswordHelper;
import ru.kpfu.itis.gadelev.net.model.Driver;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.service.DriverService;
import ru.kpfu.itis.gadelev.net.service.PassengerService;
import ru.kpfu.itis.gadelev.net.service.impl.DriverServiceImpl;
import ru.kpfu.itis.gadelev.net.service.impl.PassengerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.CollationKey;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
private final PassengerDao<Passenger> passengerPassengerDao = new PassengerDaoImpl();
private final PassengerService passengerService = new PassengerServiceImpl();
private final DriverService driverService = new DriverServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("err", null);
        if (req.getAttribute("err") != null) {
       req.setAttribute("err","err");
        }else{
            req.setAttribute("err",null);
        }
        req.getRequestDispatcher("login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = PasswordHelper.encrypt(req.getParameter("password"));
            PassengerDto passenger = passengerService.getByLogin(login);
            if(passenger!=null) {
                if (password.equals(passenger.getPassword())) {
                    req.getSession().setAttribute("passenger", passenger);
                    if (req.getParameter("remember") != null) {
                        Cookie[] cookies = req.getCookies();
                        if (cookies != null) {
                            for (Cookie c : cookies) {
                                c.setMaxAge(0);
                                resp.addCookie(c);
                            }
                        }
                        Cookie passengerCookie = new Cookie("id", String.valueOf(passenger.getId()));
                        passengerCookie.setMaxAge(24 * 60 * 60);
                        resp.addCookie(passengerCookie);
                    }
                    resp.sendRedirect("/passenger");
                }else{
                    req.setAttribute("err","error");
                    req.getRequestDispatcher("login.ftl").forward(req,resp);
                }
            }else {
                DriverDto driver = driverService.getByLogin(login);
                if (driver != null) {
                    if (password.equals(driver.getPassword())) {
                        req.getSession().setAttribute("driver", driver);
                        if(req.getParameter("remember")!=null) {
                            Cookie[] cookies = req.getCookies();
                            if (cookies != null) {
                                for (Cookie c : cookies) {
                                    c.setMaxAge(0);
                                    resp.addCookie(c);
                                }
                            }
                            Cookie driverCookie = new Cookie("id",String.valueOf(driver.getId()));
                            driverCookie.setMaxAge(24*60*60);
                            resp.addCookie(driverCookie);
                        }
                            resp.sendRedirect("/driver");

                    } else {
                        req.setAttribute("err","error");
                        req.getRequestDispatcher("login.ftl").forward(req,resp);
                    }
                } else {
                    req.setAttribute("err","error");
                    req.getRequestDispatcher("login.ftl").forward(req,resp);
                }
            }
    }
}

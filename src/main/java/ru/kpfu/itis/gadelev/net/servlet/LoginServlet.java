package ru.kpfu.itis.gadelev.net.servlet;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.gadelev.net.dao.UserDao;
import ru.kpfu.itis.gadelev.net.dao.impl.DriverUserDaoImpl;
import ru.kpfu.itis.gadelev.net.dao.impl.PassengerUserDaoImpl;
import ru.kpfu.itis.gadelev.net.helper.PasswordHelper;
import ru.kpfu.itis.gadelev.net.model.Driver;
import ru.kpfu.itis.gadelev.net.model.Passenger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
private final UserDao<Passenger> passengerUserDao = new PassengerUserDaoImpl();
private final UserDao<Driver> driverUserDao = new DriverUserDaoImpl();
    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = PasswordHelper.encrypt(req.getParameter("password"));
            Passenger passenger = passengerUserDao.get(login);
            if(passenger!=null) {
                if (password.equals(passenger.getPassword())) {
                    req.getSession().setAttribute("passenger", passenger);
                    req.getRequestDispatcher("main.ftl").forward(req, resp);
                }else{
                    resp.sendRedirect("/login");
                }
            }else{
            Driver driver = driverUserDao.get(login);
            if(driver!=null) {
                if (password.equals(driver.getPassword())) {
                    req.getSession().setAttribute("driver", driver);
                    resp.addCookie(new Cookie("id",String.valueOf(driver.getId())));
                    req.getRequestDispatcher("main.ftl").forward(req, resp);
                } else {
                    resp.sendRedirect("/login");
                }
            }else {
                resp.sendRedirect("/login");
            }
        }










    }
}

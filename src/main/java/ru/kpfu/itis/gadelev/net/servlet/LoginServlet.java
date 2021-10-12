package ru.kpfu.itis.gadelev.net.servlet;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.gadelev.net.dao.Dao;
import ru.kpfu.itis.gadelev.net.dao.impl.PassengerDaoImpl;
import ru.kpfu.itis.gadelev.net.helper.PasswordHelper;
import ru.kpfu.itis.gadelev.net.model.Passenger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
private final Dao<Passenger> passengerDao = new PassengerDaoImpl();
    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = PasswordHelper.encrypt(req.getParameter("password"));
        Passenger passenger = passengerDao.get(login);
        if(password.equals(passenger.getPassword())){
        req.getSession().setAttribute("passenger",passenger);
            req.getRequestDispatcher("main.ftl").forward(req,resp);
        }else {
            resp.sendRedirect("/login");
        }


    }
}

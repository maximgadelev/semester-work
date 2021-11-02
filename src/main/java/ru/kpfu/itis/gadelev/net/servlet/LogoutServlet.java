package ru.kpfu.itis.gadelev.net.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("passenger");
        req.getSession().removeAttribute("driver");
        req.getSession().removeAttribute("driverCar");
        req.getSession().removeAttribute("trip");
        req.getSession().removeAttribute("places");
        req.getSession().removeAttribute("driverEndTrips");
        req.getSession().removeAttribute("driverActiveTrips");
        req.getSession().removeAttribute("passengersActiveTrips");
        req.getSession().removeAttribute("passengersEndTrips");
        req.getSession().removeAttribute("car");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("passenger_id") || cookie.getName().equals("driver_id") || cookie.getName().equals("places") || cookie.getName().equals("car_id")){
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }

        req.getRequestDispatcher("login.ftl").forward(req,resp);
    }
}

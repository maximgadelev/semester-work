package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.model.DriverFeedback;
import ru.kpfu.itis.gadelev.net.service.DriverService;
import ru.kpfu.itis.gadelev.net.service.DriversFeedbackService;
import ru.kpfu.itis.gadelev.net.service.impl.DriverServiceImpl;
import ru.kpfu.itis.gadelev.net.service.impl.DriversFeedbackServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addFeedbackForDriver")
public class AddFeedbackForDriver extends HttpServlet {
    DriversFeedbackService driversFeedbackService = new DriversFeedbackServiceImpl();
    DriverService driverService = new DriverServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String driver_id=req.getParameter("driverId");
        resp.addCookie(new Cookie("driverIdFeedback",driver_id));
        req.getRequestDispatcher("AddFeedbackForDriver.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        PassengerDto passengerDto = (PassengerDto)req.getSession().getAttribute("passenger");
        int passenger_id = passengerDto.getId();

        int drId=0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("driverIdFeedback")) {
                drId = Integer.parseInt(cookie.getValue());
            }
        }
        DriverFeedback driverFeedback = new DriverFeedback(drId,req.getParameter("feedback"),passenger_id,Integer.parseInt(req.getParameter("rating")));
        double rating=driversFeedbackService.getRating(driverFeedback.getDriver_id());
        driverService.updateRating(rating,driverFeedback.getDriver_id());
        driversFeedbackService.save(driverFeedback);
        resp.sendRedirect("/passenger");
    }
}

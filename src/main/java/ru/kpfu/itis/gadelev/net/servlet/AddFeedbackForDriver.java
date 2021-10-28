package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.model.DriverFeedback;
import ru.kpfu.itis.gadelev.net.service.DriversFeedbackService;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String driver_id=req.getParameter("driverId");
        resp.addCookie(new Cookie("driverIdFeedback",driver_id));
        req.getRequestDispatcher("AddFeedbackForDriver.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        int passenger_id = 0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("passenger_id")) {
                passenger_id = Integer.parseInt(cookie.getValue());
            }
        }
        int drId=0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("driverIdFeedback")) {
                drId = Integer.parseInt(cookie.getValue());
            }
        }
        driversFeedbackService.save(new DriverFeedback(drId,req.getParameter("feedback"),passenger_id
        ));
        resp.sendRedirect("/passenger");
    }
}

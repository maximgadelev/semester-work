package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.model.PassengerFeedback;
import ru.kpfu.itis.gadelev.net.service.PassengerService;
import ru.kpfu.itis.gadelev.net.service.PassengersFeedbackService;
import ru.kpfu.itis.gadelev.net.service.impl.PassengerServiceImpl;
import ru.kpfu.itis.gadelev.net.service.impl.PassengersFeedbackServiceImpl;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(urlPatterns = "/addFeedbackForPassenger")
public class AddFeedbackForPassenger extends HttpServlet {
    PassengersFeedbackService feedbackService = new PassengersFeedbackServiceImpl();
    PassengerService passengerService = new PassengerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String string = req.getParameter("pId");
        resp.addCookie(new Cookie("feedbackPassengerId",string));
        req.getRequestDispatcher("AddFeedbackForPassenger.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        int driver_id = 0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("driver_id")) {
                driver_id = Integer.parseInt(cookie.getValue());
            }
        }
        int pasId=0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("feedbackPassengerId")) {
                pasId = Integer.parseInt(cookie.getValue());
            }
        }
            PassengerFeedback passengerFeedback=new PassengerFeedback(pasId, req.getParameter("feedback"), driver_id,Integer.parseInt(req.getParameter("rating")));
        double rating=feedbackService.getRating(passengerFeedback.getPassenger_id());
        passengerService.updateRating(passengerFeedback.getPassenger_id(),rating);
        feedbackService.save(passengerFeedback);
        resp.sendRedirect("/driver");
        }
    }


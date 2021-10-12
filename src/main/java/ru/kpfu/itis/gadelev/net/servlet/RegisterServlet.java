package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.service.PassengerService;
import ru.kpfu.itis.gadelev.net.service.impl.PassengerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/registration")
public class RegisterServlet extends HttpServlet {
    private final PassengerService passengerService = new PassengerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.sendRedirect("registeration.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            boolean saveResult = passengerService.save(new Passenger(req.getParameter("name"),req.getParameter("surname"),req.getParameter("login"),req.getParameter("password")));
            if(saveResult){
                resp.sendRedirect("/login");
            }else {
                resp.sendRedirect("/registration");
            }

    }
}

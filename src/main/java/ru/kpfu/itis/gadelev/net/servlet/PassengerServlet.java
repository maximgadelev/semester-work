package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dao.impl.PassengerDaoImpl;
import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.service.PassengerService;
import ru.kpfu.itis.gadelev.net.service.impl.PassengerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(urlPatterns = "/passengers")
public class PassengerServlet extends HttpServlet {
    private final PassengerService passengerService = new PassengerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PassengerDto> passengers = passengerService.getAll();
        req.setAttribute("passengers",passengers);
        req.getRequestDispatcher("passengers.ftl").forward(req,resp);
    }

}

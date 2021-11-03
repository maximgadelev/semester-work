package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.model.Driver;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.service.DriverService;
import ru.kpfu.itis.gadelev.net.service.PassengerService;
import ru.kpfu.itis.gadelev.net.service.impl.DriverServiceImpl;
import ru.kpfu.itis.gadelev.net.service.impl.PassengerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registration")
public class RegisterServlet extends HttpServlet {
    private final PassengerService passengerService = new PassengerServiceImpl();
    private final DriverService driverService = new DriverServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.sendRedirect("registration.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String value= req.getParameter("check");
            if(value.equals("passenger")){
                boolean saveResultPassenger = passengerService.save(new Passenger(req.getParameter("name"),req.getParameter("surname"),req.getParameter("login"),req.getParameter("password"),req.getParameter("dateOfBirth")));
                if(saveResultPassenger){
                    resp.sendRedirect("/login");
                }else {
                    resp.sendRedirect("/registration");
                }
            }else{
                boolean saveResultDriver=driverService.save(new Driver(req.getParameter("name"),req.getParameter("surname"),req.getParameter("login"),req.getParameter("password"),req.getParameter("dateOfBirth")));
                    if(saveResultDriver){
                        resp.sendRedirect("/login");
                    }else {
                        resp.sendRedirect("/registration");
                }
            }

    }
}

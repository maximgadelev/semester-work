package ru.kpfu.itis.gadelev.net.servlet;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.helper.CloudinaryHelper;
import ru.kpfu.itis.gadelev.net.helper.ImageHelper;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.service.PassengerService;
import ru.kpfu.itis.gadelev.net.service.impl.PassengerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/passenger")
public class PassengerServlet extends HttpServlet {
    private final Cloudinary cloudinary = CloudinaryHelper.getInstance();
    private final PassengerService passengerService = new PassengerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
       req.setAttribute("passenger",httpSession.getAttribute("passenger"));
        req.getRequestDispatcher("passenger.ftl").forward(req, resp);
    }

}

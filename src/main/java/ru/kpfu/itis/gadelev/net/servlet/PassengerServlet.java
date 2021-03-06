package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.helper.CookieHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/passenger")
public class
PassengerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        CookieHelper.checkCookie(req);
       req.setAttribute("passenger",httpSession.getAttribute("passenger"));
        req.getRequestDispatcher("passenger.ftl").forward(req, resp);
    }

}

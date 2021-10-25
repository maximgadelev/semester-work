package ru.kpfu.itis.gadelev.net.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/tripsBySearch")
public class TripsBySearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        req.setAttribute("trips",httpSession.getAttribute("trips"));
        req.getRequestDispatcher("TripsBySearch.ftl").forward(req,resp);



    }
}

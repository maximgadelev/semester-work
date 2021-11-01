package ru.kpfu.itis.gadelev.net.servlet;

import ru.kpfu.itis.gadelev.net.dto.TripDto;
import ru.kpfu.itis.gadelev.net.service.TripService;
import ru.kpfu.itis.gadelev.net.service.impl.TripServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns ="/main")
public class MainServlet extends HttpServlet {
    private final TripService tripService = new TripServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("main.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String from = req.getParameter("first");
        String to = req.getParameter("second");
        String path = from + "-" + to;
        resp.addCookie(new Cookie("places",req.getParameter("places")));
        List<TripDto> trips=tripService.getBySearch(req.getParameter("date"),req.getParameter("time"),path,Integer.parseInt(req.getParameter("places")));
        if(trips.isEmpty()){
            resp.sendRedirect("/main");
        }else{
            if(req.getParameter("check")!=null){
                trips=trips.stream().sorted(((o1, o2) -> o1.getPrice()-o2.getPrice())).collect(Collectors.toList());
                req.getSession().setAttribute("trips",trips);
                resp.sendRedirect("/tripsBySearch");
            }else{
            req.getSession().setAttribute("trips",trips);
            resp.sendRedirect("/tripsBySearch");
        }


    }

}
}

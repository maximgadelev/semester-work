package ru.kpfu.itis.gadelev.net.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("passenger");
        req.getSession().removeAttribute("driver");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("id")){
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }

        req.getRequestDispatcher("login.ftl").forward(req,resp);
    }
}

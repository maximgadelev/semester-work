package ru.kpfu.itis.gadelev.net.helper;

import ru.kpfu.itis.gadelev.net.dto.DriverDto;
import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.service.DriverService;
import ru.kpfu.itis.gadelev.net.service.PassengerService;
import ru.kpfu.itis.gadelev.net.service.impl.DriverServiceImpl;
import ru.kpfu.itis.gadelev.net.service.impl.PassengerServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CookieHelper {
    private static final DriverService  driverService= new DriverServiceImpl();
    private static final PassengerService passengerService = new PassengerServiceImpl();

    public static void checkCookie(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        if(httpSession.getAttribute("driver")==null && httpSession.getAttribute("passeneger")==null){
            Cookie[] cookie = request.getCookies();
            if(cookie!=null){
                for(Cookie c :cookie){
                    if(c.getName().equals("id")){
                        DriverDto driverDto = driverService.getById(Integer.parseInt(c.getValue()));
                        if(driverDto!=null){
                            httpSession.setAttribute("driver",driverDto);
                            request.setAttribute("driver",driverDto);
                        }else{
                            PassengerDto passengerDto = passengerService.get(Integer.parseInt(c.getValue()));
                            httpSession.setAttribute("passenger",passengerDto);
                            request.setAttribute("passenger",passengerDto);
                        }
                    }
                }
            }
        }
    }

}

package ru.kpfu.itis.gadelev.net.servlet;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.helper.CloudinaryHelper;
import ru.kpfu.itis.gadelev.net.helper.ImageHelper;
import ru.kpfu.itis.gadelev.net.model.Driver;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.service.PassengerService;
import ru.kpfu.itis.gadelev.net.service.impl.PassengerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Map;

@WebServlet(urlPatterns = "/upload")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024
)
public class UploadServlet extends HttpServlet {

    private final Cloudinary cloudinary = CloudinaryHelper.getInstance();

    private final PassengerService service = new PassengerServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File file = getFile(request);
        HttpSession httpSession = request.getSession();
        if(httpSession.getAttribute("passenger")!=null){
            Passenger passenger = (Passenger)httpSession.getAttribute("passenger");

            String filename = "passengerPhoto" + passenger.getId();

            Map upload =  cloudinary.uploader().upload(file,
                    ObjectUtils.asMap("public_id", filename));
            String url = (String) upload.get("url");
            passenger.setProfileImage(url);
            service.changePhoto(passenger.getId(),url);
            response.sendRedirect("/passenger");
        }else if(httpSession.getAttribute("driver")!=null){
            Driver driver = (Driver) httpSession.getAttribute("driver");
            String filename = "DriverPhoto" + driver.getId();
            Map upload =  cloudinary.uploader().upload(file,
                    ObjectUtils.asMap("public_id", filename));
            String url = (String) upload.get("url");
            driver.setProfileImage(url);
            service.changePhoto(driver.getId(),url);
            response.sendRedirect("/driver");
        }


    }

    private File getFile(HttpServletRequest request) throws IOException, ServletException {
        Part part = request.getPart("file");
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        InputStream content = part.getInputStream();
        File file = new File(fileName);
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] buffer = new byte[content.available()];
        content.read(buffer);
        outputStream.write(buffer);

        return file;

    }
}

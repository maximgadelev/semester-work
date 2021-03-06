package ru.kpfu.itis.gadelev.net.servlet;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import ru.kpfu.itis.gadelev.net.dto.DriverDto;
import ru.kpfu.itis.gadelev.net.dto.PassengerDto;
import ru.kpfu.itis.gadelev.net.helper.CloudinaryHelper;
import ru.kpfu.itis.gadelev.net.helper.ImageHelper;
import ru.kpfu.itis.gadelev.net.model.Driver;
import ru.kpfu.itis.gadelev.net.model.Passenger;
import ru.kpfu.itis.gadelev.net.service.DriverService;
import ru.kpfu.itis.gadelev.net.service.PassengerService;
import ru.kpfu.itis.gadelev.net.service.impl.DriverServiceImpl;
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
    private final DriverService driverService = new DriverServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File file = getFile(request);
        HttpSession httpSession = request.getSession();
        if(httpSession.getAttribute("passenger")!=null){
            PassengerDto passengerDto = (PassengerDto)httpSession.getAttribute("passenger");

            String filename = "passengerPhoto" + passengerDto.getId();

            Map upload =  cloudinary.uploader().upload(file,
                    ObjectUtils.asMap("public_id", filename));
            String url = (String) upload.get("url");
            passengerDto.setProfile_image(url);
            service.changePhoto(passengerDto.getId(),url);
            response.sendRedirect("/passenger");

        }else if(httpSession.getAttribute("driver")!=null){
            DriverDto driver = (DriverDto) httpSession.getAttribute("driver");
            String filename = "DriverPhoto" + driver.getId();
            Map upload =  cloudinary.uploader().upload(file,
                    ObjectUtils.asMap("public_id", filename));
            String url = (String) upload.get("url");
            driver.setProfile_image(url);
            driverService.changePhoto(driver.getId(),url);
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

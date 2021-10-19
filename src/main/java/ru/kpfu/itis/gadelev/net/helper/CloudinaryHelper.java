package ru.kpfu.itis.gadelev.net.helper;
import com.cloudinary.Cloudinary;

import java.util.HashMap;
import java.util.Map;

public class CloudinaryHelper {
    private static Cloudinary cloudinary;

    public static Cloudinary getInstance() {
        if (cloudinary == null){
            Map configMap = new HashMap();
            configMap.put("cloud_name", "itis.gadelev");
            configMap.put("api_key", "755316767329253");
            configMap.put("api_secret", "esbSnamgtI3O2p_G2y8yfxhS9SM");
            cloudinary = new Cloudinary(configMap);
        }
        return cloudinary;
    }
}
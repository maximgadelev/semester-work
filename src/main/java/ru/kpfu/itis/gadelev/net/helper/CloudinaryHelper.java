package ru.kpfu.itis.gadelev.net.helper;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

public class CloudinaryHelper {
    private static Cloudinary cloudinary;

    public static Cloudinary getInstance() {
        if (cloudinary == null) {
            cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", "itis-gadelev",
                    "api_key", "755316767329253",
                    "api_secret", "esbSnamgtI3O2p_G2y8yfxhS9SM"));
        }

        return cloudinary;
    }

}
package uz.pdp.pdp_food_delivery.rest.service.meal;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadPhotoService {

    private String UPLOAD_DIRECTORY = "src/main/resources/mealPicture/";
    public String chatIdForUploadsPhoto = "633442276";

    public String upload(MultipartFile mealPhoto) {

        String format = StringUtils.getFilenameExtension(mealPhoto.getOriginalFilename());
        String photoPath = UPLOAD_DIRECTORY + UUID.randomUUID().toString().replace("-", "") + "." + format;
        Path path = Paths.get(photoPath);
        try {
            Files.copy(mealPhoto.getInputStream(), path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return photoPath;
    }
    public void getPhoto(HttpServletResponse response, String path) {

        String[] dir = path.split("/");
        String pictureName = dir[dir.length - 1];
        response.setHeader("Content-Disposition", "filename:\"" + pictureName + "\"");
        response.setContentType("image/" + StringUtils.getFilenameExtension(pictureName));
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            FileCopyUtils.copy(fileInputStream, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package uz.pdp.pdp_food_delivery.rest.service.meal;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.pdp_food_delivery.rest.repository.meal.MealPictureRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadPhoto {
    private final MealPictureRepository mealPictureRepository;
    private String UPLOAD_DIRECTORY = "src/main/resources/mealPicture/";
    public String chatIdForUploadsPhoto = "633442276";

    public UploadPhoto(MealPictureRepository mealPictureRepository) {
        this.mealPictureRepository = mealPictureRepository;
    }

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
}

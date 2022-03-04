package uz.pdp.pdp_food_delivery.rest.service.meal;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.pdp_food_delivery.rest.entity.meal.MealPicture;
import uz.pdp.pdp_food_delivery.rest.repository.meal.MealPictureRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class MealPictureService {

    private final MealPictureRepository mealPictureRepository;
    public static String UPLOAD_DIRECTORY = "src/main/resources/MealPictures/";

    public MealPictureService(MealPictureRepository mealPictureRepository) {
        this.mealPictureRepository = mealPictureRepository;
    }

    public MealPicture create(MultipartFile picture) {

        MealPicture mealPicture = new MealPicture();
        mealPicture.setSize(picture.getSize());
        mealPicture.setImageName(picture.getName());
        String[] str = picture.getName().split("\\.");
        mealPicture.setFormat(str[str.length - 1]);
        mealPicture.setGeneratedName(UUID.randomUUID().toString().replace("-", "") + "." + mealPicture.getFormat());


        Path path = Paths.get(UPLOAD_DIRECTORY + mealPicture.getGeneratedName());

        try {
            Files.copy(picture.getInputStream(), path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mealPicture;
    }

}

package uz.pdp.pdp_food_delivery.rest.service.meal;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import uz.pdp.pdp_food_delivery.rest.entity.meal.MealPicture;
import uz.pdp.pdp_food_delivery.rest.repository.meal.MealPictureRepository;
import uz.pdp.pdp_food_delivery.telegrambot.PdpFoodDeliveryBot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class MealPictureService {

    private final MealPictureRepository mealPictureRepository;
    private final PdpFoodDeliveryBot BOT;
    private final String UPLOAD_DIRECTORY = "src/main/resources/MealPictures/";
    public String chatIdForUploadsPhoto = "blabla";//TODO chatId kerak

    public MealPictureService(MealPictureRepository mealPictureRepository, PdpFoodDeliveryBot bot) {
        this.mealPictureRepository = mealPictureRepository;
        BOT = bot;
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

        Integer photoMessageId = uploadMealPictureOnTelegramServer(UPLOAD_DIRECTORY + mealPicture.getGeneratedName(), chatIdForUploadsPhoto);
        mealPicture.setIdOnTgServer(photoMessageId);
        mealPictureRepository.save(mealPicture);

        return mealPicture;
    }

    private Integer uploadMealPictureOnTelegramServer(String path, String chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile(new File(path)));

        return BOT.executeMealPicture(sendPhoto);
    }

}

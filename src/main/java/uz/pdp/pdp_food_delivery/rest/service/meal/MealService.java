package uz.pdp.pdp_food_delivery.rest.service.meal;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.meal.Meal;
import uz.pdp.pdp_food_delivery.rest.entity.meal.MealPicture;
import uz.pdp.pdp_food_delivery.rest.mapper.meal.MealMapper;
import uz.pdp.pdp_food_delivery.rest.repository.meal.MealPictureRepository;
import uz.pdp.pdp_food_delivery.rest.repository.meal.MealRepository;
import uz.pdp.pdp_food_delivery.rest.service.base.AbstractService;
import uz.pdp.pdp_food_delivery.rest.service.base.BaseService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;
import uz.pdp.pdp_food_delivery.telegrambot.PdpFoodDeliveryBot;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static uz.pdp.pdp_food_delivery.rest.service.meal.MealPictureService.UPLOAD_DIRECTORY;

@Service
public class MealService extends AbstractService<MealMapper, MealRepository>
        implements GenericCrudService<MealCreateDto, MealUpdateDto>, GenericService<MealDto>, BaseService {

    private final PdpFoodDeliveryBot BOT;
    private final MealPictureService mealPictureService;
    private final MealPictureRepository mealPictureRepository;
    public String chatIdForUploadsPhoto = "blabla";//TODO chatId kerak

    public MealService(MealMapper mapper, MealRepository repository, PdpFoodDeliveryBot bot, MealPictureService mealPictureService, MealPictureRepository mealPictureRepository) {
        super(mapper, repository);
        BOT = bot;
        this.mealPictureService = mealPictureService;
        this.mealPictureRepository = mealPictureRepository;
    }

    @Override
    public Long create(MealCreateDto mealCreateDto) {

        Meal meal = mapper.fromCreateDto(mealCreateDto);
        MealPicture mealPicture = mealPictureService.create(mealCreateDto.getPicture());
        Integer photoMessageId = uploadMealPictureOnTelegramServer(UPLOAD_DIRECTORY + meal.getPicture().getGeneratedName(), chatIdForUploadsPhoto);

        mealPicture.setIdOnTgServer(photoMessageId);
        meal.setPicture(mealPicture);

        mealPictureRepository.save(mealPicture);
        repository.save(meal);

        return meal.getId();

    }

    public Long create(MealCreateDto mealCreateDto, Long sesId) {

        Meal meal = mapper.fromCreateDto(mealCreateDto);
        MealPicture mealPicture = mealPictureService.create(mealCreateDto.getPicture());
        Integer photoMessageId = uploadMealPictureOnTelegramServer(UPLOAD_DIRECTORY + meal.getPicture().getGeneratedName(), chatIdForUploadsPhoto);

        mealPicture.setIdOnTgServer(photoMessageId);

        meal.setCreatedBy(sesId);
        meal.setPicture(mealPicture);

        mealPictureRepository.save(mealPicture);
        repository.save(meal);

        return meal.getId();

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(MealUpdateDto mealUpdateDto) {

        Optional<Meal> meal = repository.findById(mealUpdateDto.getId());
        mapper.fromUpdateDto(mealUpdateDto, meal.get());

        if (Objects.nonNull(mealUpdateDto.getPicture())) {
            meal.get().setPicture(mealPictureService.create(mealUpdateDto.getPicture()));
        }
        repository.save(meal.get());
    }

    public void update(MealUpdateDto mealUpdateDto, Long sesId) {

        Optional<Meal> meal = repository.findById(mealUpdateDto.getId());

        mapper.fromUpdateDto(mealUpdateDto, meal.get());

        if (Objects.nonNull(mealUpdateDto.getPicture())) {
            meal.get().setPicture(mealPictureService.create(mealUpdateDto.getPicture()));
        }

        meal.get().setUpdatedBy(sesId);
        repository.save(meal.get());


    }


    @Override
    public List<MealDto> getAll() {


        return null;
    }

    @Override
    public MealDto get(Long id) {
        Optional<Meal> meal = repository.findById(id);

        return null;
    }

    private Integer uploadMealPictureOnTelegramServer(String path, String chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile(new File(path)));

        return BOT.executeMealPicture(sendPhoto);
    }

//
//    public List<MealDto> getAllByLimit(Pageable pageable) {
//        List<Meal> meals = repository.findAll(pageable).getContent();
//        return mapper.toDto(meals);
//
//        List<Meal> meals = repository.getAllByLimit(limitState, offset);
//        return mapper.toDto(meals);
//    }

//
//
//    private List<HttpServletResponse> setPictureContent(List<MealPicture> mealPictures) {
//        List<HttpServletResponse> httpServletResponses = new ArrayList<>();
//        for (MealPicture mealPicture : mealPictures) {
//            Optional<MealPictureContent> mealPictureContent = mealPictureContentRepository.findByPictureId(mealPicture.getId());
//            HttpServletResponse response = new Response();
//            response.setContentType(mealPicture.getContentType());
//            response.setHeader("Content-Disposition", "attachment; filename=\"" + mealPicture.getOriginalName() + "\"");
//
//        }
//    }
//
//    private void uploadPictures(MultipartHttpServletRequest multipartHttpServletRequest, Meal meal) {
//
//        Iterator<String> pictureNames = multipartHttpServletRequest.getFileNames();
//        while (pictureNames.hasNext()) {
//            MultipartFile picture = multipartHttpServletRequest.getFile(pictureNames.next());
//            MealPicture mealPicture = toMealPicture(picture, meal);
//            MealPicture saveMealPicture = mealPictureRepository.save(mealPicture);
//            try {
//                uploadPicturesContent(picture, saveMealPicture);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    private void uploadPicturesContent(MultipartFile pictureContent, MealPicture saveMealPicture) throws IOException {
//        MealPictureContent content = new MealPictureContent();
//        content.setContent(pictureContent.getBytes());
//        content.setPicture(saveMealPicture);
//        mealPictureContentRepository.save(content);
//    }
//
//    private MealPicture toMealPicture(MultipartFile picture, Meal meal) {
//        MealPicture mealPicture = new MealPicture();
//        if (picture != null) {
//            mealPicture.setMeal(meal);
//            mealPicture.setOriginalName(picture.getOriginalFilename());
//            mealPicture.setSize(picture.getSize());
//            mealPicture.setCreatedBy(meal.getCreatedBy());
//            mealPicture.setContentType(picture.getContentType());
//        }
//        return mealPicture;
//    }
//
//    private List<HttpServletResponse> getMealPictures(Long mealId) {
//
//        List<MealPicture> mealPictures = mealPictureRepository.findAllByMealId(mealId);
//        return setPictureContent(mealPictures);
//    }


}

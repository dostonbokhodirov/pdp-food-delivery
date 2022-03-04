package uz.pdp.pdp_food_delivery.rest.service.mealorder;

import org.springframework.stereotype.Service;
import uz.pdp.pdp_food_delivery.rest.dto.mealorder.MealOrderCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.mealorder.MealOrderDto;
import uz.pdp.pdp_food_delivery.rest.entity.MealOrder;
import uz.pdp.pdp_food_delivery.rest.mapper.mealorder.MealOrderMapper;
import uz.pdp.pdp_food_delivery.rest.repository.mealorder.MealOrderRepository;
import uz.pdp.pdp_food_delivery.rest.service.base.AbstractService;
import uz.pdp.pdp_food_delivery.rest.service.base.BaseService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class MealOrderService extends AbstractService<MealOrderMapper, MealOrderRepository>
        implements GenericCrudService<MealOrderCreateDto, MealOrderDto>, GenericService<MealOrderDto>, BaseService {

    public MealOrderService(MealOrderMapper mapper, MealOrderRepository repository) {
        super(mapper, repository);
    }


    //this two times are used for checking dates(present or not)
    public static LocalTime after = LocalTime.of(18, 0, 0);
    public static LocalTime before = LocalTime.of(10, 0, 0);

    @Override
    public List<MealOrderDto> getAll() {

        List<MealOrder> orders = repository.findAll();
        return mapper.toDto(orders);
    }

    @Override
    public MealOrderDto get(Long id) {
        Optional<MealOrder> byId = repository.findById(id);

        if (byId.isPresent()) {
            MealOrder mealOrder = byId.get();
            MealOrderDto dto = mapper.toDto(mealOrder);
            return dto;
        } else {
            throw new RuntimeException("Order not found");
        }

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(MealOrderDto mealOrderDto) {

    }

    @Override
    public Long create(MealOrderCreateDto mealOrderCreateDto) {
        MealOrder mealOrder = mapper.fromCreateDto(mealOrderCreateDto);
        MealOrder save = repository.save(mealOrder);
        return save.getId();
    }


    public List<MealOrderCreateDto> findOrderForExcelFile(LocalDateTime date) {

        Date sqlDate = Date.valueOf(date.toLocalDate());

        List<MealOrder> orders = repository.findByDate(sqlDate);

        List<MealOrderCreateDto> dto = mapper.toCreateDto(orders);
        return dto;
    }


}

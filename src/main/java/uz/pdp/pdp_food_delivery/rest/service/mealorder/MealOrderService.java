package uz.pdp.pdp_food_delivery.rest.service.mealorder;

import org.springframework.stereotype.Service;
import uz.pdp.pdp_food_delivery.rest.dto.mealorder.MealOrderDto;
import uz.pdp.pdp_food_delivery.rest.mapper.mealorder.MealOrderMapper;
import uz.pdp.pdp_food_delivery.rest.repository.mealorder.MealOrderRepository;
import uz.pdp.pdp_food_delivery.rest.service.base.AbstractService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;

import java.time.LocalTime;
import java.util.List;

@Service
public class MealOrderService extends AbstractService<MealOrderMapper, MealOrderRepository>
        implements GenericService<MealOrderDto> {

    public MealOrderService(MealOrderMapper mapper, MealOrderRepository repository) {
        super(mapper, repository);
    }



    //this two times are used for checking dates(present or not)
    public static LocalTime after = LocalTime.of(18,0,0);
    public static LocalTime before = LocalTime.of(10,0,0);


    @Override
    public List<MealOrderDto> getAll() {
        return null;
    }

    @Override
    public MealOrderDto get(Long id) {
        return null;
    }
}

package uz.pdp.pdp_food_delivery.rest.service.mealorder;

import org.springframework.stereotype.Service;
import uz.pdp.pdp_food_delivery.rest.dto.mealorder.MealOrderCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.mealorder.MealOrderDto;
import uz.pdp.pdp_food_delivery.rest.dto.mealorder.MealOrderUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.MealOrder;
import uz.pdp.pdp_food_delivery.rest.mapper.mealorder.MealOrderMapper;
import uz.pdp.pdp_food_delivery.rest.repository.mealorder.MealOrderRepository;
import uz.pdp.pdp_food_delivery.rest.service.base.AbstractService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MealOrderService extends AbstractService<MealOrderMapper, MealOrderRepository>
        implements GenericCrudService<
        MealOrder,
        MealOrderDto,
        MealOrderCreateDto,
        MealOrderUpdateDto> {

    public MealOrderService(MealOrderMapper mapper, MealOrderRepository repository) {
        super(mapper, repository);
    }

    @Override
    public List<MealOrderDto> getAll() {
        return null;
    }

    @Override
    public MealOrderDto get(Long id) {
        return null;
    }

    public List<MealOrderCreateDto> findOrderForExcelFile(LocalDateTime date) {
        return null;
    }

    @Override
    public Long create(MealOrderCreateDto createDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(MealOrderUpdateDto updateDto) {

    }
}

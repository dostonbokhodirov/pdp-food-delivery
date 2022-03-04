package uz.pdp.pdp_food_delivery.rest.service.dailymeal;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealDto;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealUpdateDto;
import uz.pdp.pdp_food_delivery.rest.mapper.dailymeal.DailyMealMapper;
import uz.pdp.pdp_food_delivery.rest.repository.dailymeal.DailyMealRepository;
import uz.pdp.pdp_food_delivery.rest.service.base.AbstractService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;

import java.util.List;

@Service
public class DailyMealService extends AbstractService<DailyMealMapper, DailyMealRepository>
        implements GenericCrudService<DailyMealCreateDto, DailyMealUpdateDto>, GenericService<DailyMealDto> {


    public DailyMealService(DailyMealMapper mapper, DailyMealRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(DailyMealUpdateDto dailyMealUpdateDto) {

    }

    @Override
    public Long create(DailyMealCreateDto dailyMealCreateDto) {
        return null;
    }

    @Override
    public List<DailyMealDto> getAll() {
        return null;
    }

    @Override
    public DailyMealDto get(Long id) {
        return null;
    }
}

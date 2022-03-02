package uz.pdp.pdp_food_delivery.rest.service.base;

import org.springframework.stereotype.Service;
import uz.pdp.pdp_food_delivery.rest.dto.BaseDto;
import uz.pdp.pdp_food_delivery.rest.dto.GenericDto;


@Service
public interface GenericCrudService<CD extends BaseDto, UD extends GenericDto> {

    void delete(Long id);

    void update(UD ud);

    void create(CD cd);

}

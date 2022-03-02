package uz.pdp.pdp_food_delivery.rest.service.base;


import org.springframework.stereotype.Service;
import uz.pdp.pdp_food_delivery.rest.dto.GenericDto;

import java.util.List;

@Service
public interface GenericService<D extends GenericDto> {

    List<D> getAll();

    D get(Long id);

}

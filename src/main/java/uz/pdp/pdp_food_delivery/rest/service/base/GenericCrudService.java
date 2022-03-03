package uz.pdp.pdp_food_delivery.rest.service.base;

import org.springframework.stereotype.Service;
import uz.pdp.pdp_food_delivery.rest.dto.BaseDto;
import uz.pdp.pdp_food_delivery.rest.dto.Dto;
import uz.pdp.pdp_food_delivery.rest.dto.GenericDto;
import uz.pdp.pdp_food_delivery.rest.entity.base.BaseEntity;

import java.io.Serializable;

/**
 * @param <E>  -> Entity
 * @param <D>  -> Dto
 * @param <CD> -> Create Dto
 * @param <UD> -> Update Dto
 */
public interface GenericCrudService<
        E extends BaseEntity,
        D extends GenericDto,
        CD extends BaseDto,
        UD extends GenericDto> extends GenericService<D> {

    Long create(CD createDto);

    void delete(Long id);

    Void update(UD updateDto);

}

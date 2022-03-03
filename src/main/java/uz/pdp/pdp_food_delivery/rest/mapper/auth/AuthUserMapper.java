package uz.pdp.pdp_food_delivery.rest.mapper.auth;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserCreateDto;
import uz.pdp.pdp_food_delivery.rest.entity.AuthUser;
import uz.pdp.pdp_food_delivery.rest.mapper.BaseMapper;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper {
    AuthUser fromCreateDto(AuthUserCreateDto createDto);

}

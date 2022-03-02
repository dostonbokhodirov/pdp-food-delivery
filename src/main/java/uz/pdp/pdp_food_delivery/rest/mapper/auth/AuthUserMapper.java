package uz.pdp.pdp_food_delivery.rest.mapper.auth;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserDto;
import uz.pdp.pdp_food_delivery.rest.entity.AuthUser;
import uz.pdp.pdp_food_delivery.rest.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper {

    AuthUserDto toDto(AuthUser user);

    List<AuthUserDto> toDto(List<AuthUser> users);

}

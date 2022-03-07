package uz.pdp.pdp_food_delivery.rest.service.auth;

import org.springframework.security.core.userdetails.UserDetailsService;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserDto;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.AuthUser;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface AuthUserService extends GenericCrudService<
        AuthUser,
        AuthUserDto,
        AuthUserCreateDto,
        AuthUserUpdateDto
        >,UserDetailsService {

    List<AuthUserDto> getGivenPage(Integer page, Integer size);

    void getRefreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;


    AuthUserDto getByChatId(String chatId);
}

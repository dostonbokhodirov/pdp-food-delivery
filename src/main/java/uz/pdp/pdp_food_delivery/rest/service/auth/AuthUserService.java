package uz.pdp.pdp_food_delivery.rest.service.auth;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserDto;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserUpdateDto;
import uz.pdp.pdp_food_delivery.rest.mapper.auth.AuthUserMapper;
import uz.pdp.pdp_food_delivery.rest.repository.auth.AuthUserRepository;
import uz.pdp.pdp_food_delivery.rest.service.base.AbstractService;
import uz.pdp.pdp_food_delivery.rest.service.base.BaseService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;

import java.util.List;


@Service
public class AuthUserService extends AbstractService<AuthUserMapper, AuthUserRepository>
        implements GenericCrudService<AuthUserCreateDto, AuthUserUpdateDto>, GenericService<AuthUserDto>, BaseService {

    public AuthUserService(AuthUserMapper mapper, AuthUserRepository repository) {
        super(mapper, repository);
    }

    public void save(Message message) {

    }


    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(AuthUserUpdateDto authUserUpdateDto) {

    }

    @Override
    public void create(AuthUserCreateDto authUserCreateDto) {

    }

    @Override
    public List<AuthUserDto> getAll() {
        return null;
    }

    @Override
    public AuthUserDto get(Long id) {
        return null;
    }
}

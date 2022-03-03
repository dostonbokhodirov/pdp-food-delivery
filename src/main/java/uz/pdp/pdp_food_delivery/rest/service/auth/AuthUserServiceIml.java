package uz.pdp.pdp_food_delivery.rest.service.auth;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserDto;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserUpdateDto;
import uz.pdp.pdp_food_delivery.rest.mapper.auth.AuthUserMapper;
import uz.pdp.pdp_food_delivery.rest.repository.auth.AuthUserRepository;
import uz.pdp.pdp_food_delivery.rest.service.base.AbstractService;

import java.util.List;


@Service
public class AuthUserServiceIml extends AbstractService<AuthUserMapper, AuthUserRepository>
        implements AuthUserService {

    public AuthUserServiceIml(AuthUserMapper mapper, AuthUserRepository repository) {
        super(mapper, repository);
    }

/*
    public String getLanguage(String chatId) {
        return repository.getLanguage(chatId);
    }*/

    @Override
    public Long create(AuthUserCreateDto createDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Void update(AuthUserUpdateDto updateDto) {
        return null;
    }

    @Override
    public List<AuthUserDto> getAll() {
        return null;
    }

    @Override
    public AuthUserDto get(Long id) {
        return null;
    }

    public void save(Message message) {


    }
}

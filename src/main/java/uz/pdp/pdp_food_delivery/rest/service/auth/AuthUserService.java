package uz.pdp.pdp_food_delivery.rest.service.auth;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserDto;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.AuthUser;
import uz.pdp.pdp_food_delivery.rest.mapper.auth.AuthUserMapper;
import uz.pdp.pdp_food_delivery.rest.repository.auth.AuthUserRepository;
import uz.pdp.pdp_food_delivery.rest.service.base.AbstractService;
import uz.pdp.pdp_food_delivery.rest.service.base.BaseService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;

import java.util.List;
import java.util.Optional;


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
        Optional<AuthUser> byId = repository.findByIdAndDeleted(id, false);
        if (byId.isPresent()) {
            AuthUser authUser = byId.get();
            authUser.setDeleted(true);
            repository.save(authUser);
        } else
            throw new RuntimeException("User not found");
    }

    @Override
    public void update(AuthUserUpdateDto authUserUpdateDto) {
        String email = authUserUpdateDto.getEmail();
        Long id = authUserUpdateDto.getId();
        String password = authUserUpdateDto.getPassword();
        String phoneNumber = authUserUpdateDto.getPhoneNumber();
        String fullName = authUserUpdateDto.getFullName();

        Optional<AuthUser> byId = repository.findByIdAndDeleted(id, false);
        if (byId.isPresent()) {
            AuthUser authUser = byId.get();
            authUser.setEmail(email);
            authUser.setPassword(password);
            authUser.setPhoneNumber(phoneNumber);
            authUser.setFullName(fullName);
            repository.save(authUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public Long create(AuthUserCreateDto authUserCreateDto) {
        AuthUser authUser = mapper.fromCreateDto(authUserCreateDto);
        AuthUser save = repository.save(authUser);
        return save.getId();
    }

    @Override
    public List<AuthUserDto> getAll() {
        return null;
    }

    @Override
    public AuthUserDto get(Long id) {
        Optional<AuthUser> byIdAndDeleted = repository.findByIdAndDeleted(id, false);
        if (byIdAndDeleted.isPresent()) {
            AuthUser authUser = byIdAndDeleted.get();
            return mapper.toDto(authUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }


    public List<AuthUserDto> getGivenPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AuthUser> all = repository.findAllByDeleted(false, pageable);
        List<AuthUser> content = all.getContent();
        return mapper.toDto(content);
    }

    public Long create(AuthUserCreateDto dto, Long userId) {
        AuthUser authUser = mapper.fromCreateDto(dto);
        authUser.setCreatedBy(userId);
        AuthUser save = repository.save(authUser);
        return save.getId();
    }

//    public String getLanguage(String chatId) {
//        return repository.getLanguage(chatId);
//    }
}

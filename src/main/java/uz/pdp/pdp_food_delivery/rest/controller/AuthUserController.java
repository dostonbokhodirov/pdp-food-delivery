package uz.pdp.pdp_food_delivery.rest.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pdp_food_delivery.rest.controller.base.AbstractController;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserDto;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserUpdateDto;
import uz.pdp.pdp_food_delivery.rest.service.auth.AuthUserService;

import java.util.List;

@RestController
@RequestMapping("/auth/")
public class AuthUserController extends AbstractController<AuthUserService> {

    public AuthUserController(AuthUserService service) {
        super(service);
    }


    //Admin uchun
    @GetMapping("list")
    public List<AuthUserDto> getGivenPageAndSizeOfUsers(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(value = "size", defaultValue = "10") Integer size) {
        List<AuthUserDto> all = service.getGivenPage(page, size);
        return all;
    }


    @GetMapping("get/{id}")
    public AuthUserDto getById(@PathVariable Long id) {
        try {
            AuthUserDto authUserDto = service.get(id);
            return authUserDto;
        } catch (RuntimeException ignored) {
            return null;
        }
    }

    @PutMapping("create")
    public Long create(@RequestBody AuthUserCreateDto dto, @RequestParam(defaultValue = "null") Long userId) {
        Long aLong = service.create(dto, userId);
        return aLong;
    }

    @PatchMapping("update")
    public HttpEntity<?> update(@RequestBody AuthUserUpdateDto dto) {
        service.update(dto);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("delete/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }


}

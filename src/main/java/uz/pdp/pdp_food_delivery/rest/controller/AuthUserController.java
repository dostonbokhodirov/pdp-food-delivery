package uz.pdp.pdp_food_delivery.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.pdp_food_delivery.rest.controller.base.AbstractController;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserDto;
import uz.pdp.pdp_food_delivery.rest.service.auth.AuthUserService;

import java.util.List;

@RestController
public class AuthUserController extends AbstractController<AuthUserService> {

    public AuthUserController(AuthUserService service) {
        super(service);
    }


   /* //Admin uchun
    @GetMapping("list")
    public List<AuthUserDto> getGivenPageAndSizeOfUsers(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(value = "size", defaultValue = "10") Integer size) {
        List<AuthUserDto> all = service.getGivenPage(page, size);
        return all;
    }*/

    @GetMapping("get/{id}")
    public AuthUserDto getById(@PathVariable Long id) {
        try {
            AuthUserDto authUserDto = service.get(id);
            return authUserDto;
        } catch (RuntimeException ignored) {
            return null;
        }
    }


}

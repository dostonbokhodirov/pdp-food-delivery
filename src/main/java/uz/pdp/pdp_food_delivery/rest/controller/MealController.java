package uz.pdp.pdp_food_delivery.rest.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.pdp_food_delivery.rest.controller.base.AbstractController;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.service.meal.MealService;


@RestController
@RequestMapping(value = "/meal/")
public class MealController extends AbstractController<MealService> {


    public MealController(MealService service) {
        super(service);
    }


    @RequestMapping(value = "get/{id}")
    public MealDto get(@PathVariable Long id) {
        return service.get(id);

    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Long create(@RequestBody MealCreateDto dto, @RequestParam(defaultValue = "-1") Long sessionUserId) {
        return service.create(dto, sessionUserId);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id, @RequestParam(defaultValue = "-1") Long sessionUserId) {
        service.delete(id, sessionUserId);
    }


}

package uz.pdp.pdp_food_delivery.rest.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pdp_food_delivery.rest.controller.base.AbstractController;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.response.ResponseEntity;
import uz.pdp.pdp_food_delivery.rest.service.meal.MealService;

import javax.servlet.http.HttpServletResponse;

public class MealController extends AbstractController<MealService> {


    public MealController(MealService service) {
        super(service);
    }


    @RequestMapping(value = "get/{id}")
    public ResponseEntity<MealDto> get(@PathVariable Long id, HttpServletResponse response) {
        MealDto mealDto = service.get(id);
        return new ResponseEntity<>(mealDto);
    }


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Long> create(@RequestBody MealCreateDto dto, @RequestParam(defaultValue = "-1") Long sessionUserId) {
        Long aLong = service.create(dto, sessionUserId);
        return new ResponseEntity<>(aLong);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id, @RequestParam(defaultValue = "-1") Long sessionUserId) {
        service.delete(id, sessionUserId);
        return new ResponseEntity<>(org.springframework.http.HttpStatus.OK);
    }


}

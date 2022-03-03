package uz.pdp.pdp_food_delivery.rest.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pdp_food_delivery.rest.controller.base.AbstractController;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackDto;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackUpdateDto;
import uz.pdp.pdp_food_delivery.rest.service.feedback.FeedbackService;

import java.util.List;


@RestController
@RequestMapping("/feedback")
public class FeedbackController extends AbstractController<FeedbackService> {

    public FeedbackController(FeedbackService service) {
        super(service);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody FeedbackCreateDto dto) {
        return service.create(dto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public HttpEntity<?> update(@RequestBody FeedbackUpdateDto dto) {
        service.update(dto);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public HttpEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public FeedbackDto get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<FeedbackDto> getAll() {
        return service.getAll();
    }
}

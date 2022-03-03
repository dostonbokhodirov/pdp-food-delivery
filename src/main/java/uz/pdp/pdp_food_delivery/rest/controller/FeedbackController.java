package uz.pdp.pdp_food_delivery.rest.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.pdp_food_delivery.rest.controller.base.AbstractController;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackUpdateDto;
import uz.pdp.pdp_food_delivery.rest.service.feedback.FeedbackService;


@RestController
@RequestMapping("/feedback")
public class FeedbackController extends AbstractController<FeedbackService> {

    public FeedbackController(FeedbackService service) {
        super(service);
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public void create(@RequestBody FeedbackCreateDto dto){
        service.create(dto);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestBody FeedbackUpdateDto dto){
            service.update(dto);
            return null;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
            service.delete(id);
    }


    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public String get(@PathVariable("id") Long id){
            service.get(id);
            return null;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String getAll(){
            service.getAll();
            return null;
    }
}

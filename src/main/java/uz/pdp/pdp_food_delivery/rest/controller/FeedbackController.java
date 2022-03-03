package uz.pdp.pdp_food_delivery.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.pdp_food_delivery.rest.controller.base.AbstractController;
import uz.pdp.pdp_food_delivery.rest.service.feedback.FeedbackService;

@RestController
@RequestMapping("/feedback/*")
public class FeedbackController extends AbstractController<FeedbackService> {

    public FeedbackController(FeedbackService service) {
        super(service);
    }


}

package uz.pdp.pdp_food_delivery.rest.controller;

import uz.pdp.pdp_food_delivery.rest.controller.base.AbstractController;
import uz.pdp.pdp_food_delivery.rest.service.feedback.FeedbackService;

public class FeedbackController extends AbstractController<FeedbackService> {

    public FeedbackController(FeedbackService service) {
        super(service);
    }


}

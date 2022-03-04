package uz.pdp.pdp_food_delivery.rest.controller.base;

import uz.pdp.pdp_food_delivery.rest.service.base.BaseService;

//@RestController
public abstract class AbstractController<S extends BaseService> {

//    @Autowired
    protected final S service;

    public AbstractController(S service) {
        this.service = service;
    }
}

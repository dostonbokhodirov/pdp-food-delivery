package uz.pdp.pdp_food_delivery.rest.service.base;

import org.springframework.stereotype.Service;
import uz.pdp.pdp_food_delivery.rest.mapper.BaseMapper;
import uz.pdp.pdp_food_delivery.rest.repository.BaseRepository;

//@Service
public abstract class AbstractService<M extends BaseMapper, R extends BaseRepository> {

    protected final M mapper;
    protected final R repository;


    public AbstractService(M mapper,
                           R repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


}

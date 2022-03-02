package uz.pdp.pdp_food_delivery.rest.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.pdp_food_delivery.rest.entity.AuthUser;
import uz.pdp.pdp_food_delivery.rest.repository.BaseRepository;

@Repository
public interface  AuthUserRepository  extends JpaRepository<AuthUser,Long>, BaseRepository {



}


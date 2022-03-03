package uz.pdp.pdp_food_delivery.rest.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.pdp_food_delivery.rest.entity.AuthUser;
import uz.pdp.pdp_food_delivery.rest.enums.Role;
import uz.pdp.pdp_food_delivery.rest.repository.BaseRepository;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, BaseRepository {


    @Query(value = "select u.language from AuthUser u where u.chatId = :chatId")
    public String getLanguage(@Param(value = "chatId") String chatId);

    @Query("select u.role from AuthUser u where u.chatId = :chatId")
    public String findRoleByChatId(@Param(value = "chatId") String chatId);

}


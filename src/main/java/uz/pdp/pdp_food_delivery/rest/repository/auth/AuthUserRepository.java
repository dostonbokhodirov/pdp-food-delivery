package uz.pdp.pdp_food_delivery.rest.repository.auth;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.pdp_food_delivery.rest.entity.AuthUser;
import uz.pdp.pdp_food_delivery.rest.repository.BaseRepository;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, BaseRepository {

    Page<AuthUser> findAllByDeleted(boolean deleted, Pageable pageable);

    @Query(value = "select u.language from users.user where u.chat_id = :chatId", nativeQuery = true)
    String getLanguage(@Param(value = "chatId") String chatId);

    @Query(value = "select u.role from users.user where u.chat_id = :chatId", nativeQuery = true)
    String findRoleByChatId(@Param(value = "chatId") String chatId);

    @Query(value = "select u.role from users.user where u.chat_id = :chatId", nativeQuery = true)
    String getRole(@Param(value = "chatId") String chatId);

    boolean existsByChatId(String chatId);

    @Query(value = "select u.active from users.user where u.chat_id = :chatId", nativeQuery = true)
    boolean isActive(@Param(value = "chatId") String chatId);

    @Query(value = "update users.user set u.full_name = :fullName where u.chat_id = :chatId", nativeQuery = true)
    void updateFullName(@Param(value = "chatId") String chatId, @Param(value = "fullName") String fullName);

    @Query(value = "update users.user set u.phone_number = :phoneNumber where u.chat_id = :chatId", nativeQuery = true)
    void updatePhone(@Param(value = "chatId") String chatId, @Param(value = "phoneNumber") String phoneNumber);

    @Query(value = "update users.user set u.role = :role where u.chat_id = :chatId", nativeQuery = true)
    void updateRole(@Param(value = "chatId") String chatId, @Param(value = "role") String role);

    @Query(value = "update users.user set u.email = :text where u.chat_id = :chatId", nativeQuery = true)
    void updateEmail(@Param(value = "chatId") String chatId, @Param(value = "text") String text);

    Optional<AuthUser> findByIdAndDeleted(Long id, boolean deleted);

    @Query(value = "select u.id from users.user  u left join meal_order.meal_order mo on  u.id <> mo.user_id;", nativeQuery = true)
    ArrayList<Long> getUserIdByNoMealOrder();

    @Query(value = "select mo.user_id from meal_order.meal_order mo where mo.done='f';", nativeQuery = true)
    ArrayList<Long> getUserIdByMealOrder();

}


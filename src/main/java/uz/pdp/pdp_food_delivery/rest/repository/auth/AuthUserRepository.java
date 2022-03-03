package uz.pdp.pdp_food_delivery.rest.repository.auth;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.pdp_food_delivery.rest.entity.AuthUser;
import uz.pdp.pdp_food_delivery.rest.repository.BaseRepository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, BaseRepository {

    Page<AuthUser> findAllByDeleted(boolean deleted, Pageable pageable);

    @Query(value = "select u.language from AuthUser u where u.chatId = :chatId")
    String getLanguage(@Param(value = "chatId") String chatId);

    @Query(value = "select u.role from AuthUser u where u.chatId =:chatId")
    String getRole(@Param(value = "chatId") String chatId);

    boolean existsByChatId(String chatId);

    @Query(value = "select u.active from AuthUser u where u.chatId =:chatId")
    boolean isActive(@Param(value = "chatId")String chatId);

    @Query(value = "update AuthUser u set u.fullName =: fulName where u.chatId =:chatId ")
    void updateFullName(String chatId, String fulName);

    @Query(value = "update AuthUser u set u.phoneNumber =: phoneNumber where u.chatId =:chatId")
    void updatePhone(String chatId, String phoneNumber);

    @Query(value = "update AuthUser u set u.role =: role where u.chatId =:chatId")
    void updateRole(String chatId, String role);

    @Query(value = "update AuthUser u set u.email =: text where u.chatId =:chatId")
    void updateEmail(String chatId, String text);
    Optional<AuthUser> findByIdAndDeleted(Long id, boolean deleted);

}


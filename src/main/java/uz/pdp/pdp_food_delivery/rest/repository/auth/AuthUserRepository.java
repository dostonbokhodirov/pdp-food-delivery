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
/*

    @Query(value = "select u.language from AuthUser u where u.chatId = :chatId")
    public String getLanguage(@Param(value = "chatId") String chatId);
*/

    Optional<AuthUser> findByIdAndDeleted(Long id, boolean deleted);

/*    String getLanguage(String chatId);*/
}


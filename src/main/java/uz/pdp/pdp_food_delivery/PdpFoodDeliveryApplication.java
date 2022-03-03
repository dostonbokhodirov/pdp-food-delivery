package uz.pdp.pdp_food_delivery;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class PdpFoodDeliveryApplication {

    /* @Autowired
     AuthUserRepository authUserRepository;

 */
    public static void main(String[] args) {
        SpringApplication.run(PdpFoodDeliveryApplication.class, args);
    }

  /*  {
        AuthUser user = new AuthUser();
        user.setFullName("Saydali");
        user.setDepartment(Department.HEAD);
        user.setPassword("123");
        user.setPhoneNumber("+998973130080");
        user.setEmail("murodullayev.saydali@gmail.com");
        user.setRole(Role.ADMIN);

        AuthUser authUser = new AuthUser();
        authUser.setFullName("Saydali");
        authUser.setDepartment(Department.HEAD);
        authUser.setPassword("123");
        authUser.setPhoneNumber("+998973130080");
        authUser.setEmail("murodullayev.saydali@gmail.com");
        authUser.setRole(Role.ADMIN);

        authUserRepository.save(user);
        authUserRepository.save(authUser);
    }*/

}

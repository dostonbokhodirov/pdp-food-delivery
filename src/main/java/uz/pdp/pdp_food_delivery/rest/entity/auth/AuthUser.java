package uz.pdp.pdp_food_delivery.rest.entity.auth;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.pdp_food_delivery.rest.entity.Auditable;
import uz.pdp.pdp_food_delivery.rest.enums.Department;
import uz.pdp.pdp_food_delivery.rest.enums.Role;

import javax.persistence.Table;

@Getter
@Setter
@Table(schema = "user")
public class AuthUser extends Auditable {

    private String password;

    private String fullName;

    private String phoneNumber;

    private String email;

    private String chatId;

    private Department department;

    private Role role;

    private boolean active;

    private boolean block;

}

package uz.pdp.pdp_food_delivery.rest.entity;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.pdp_food_delivery.rest.entity.base.Auditable;
import uz.pdp.pdp_food_delivery.rest.enums.Department;
import uz.pdp.pdp_food_delivery.rest.enums.Role;
import uz.pdp.pdp_food_delivery.telegrambot.enums.Language;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "auth_user", schema = "users")
public class AuthUser extends Auditable {

    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    private String email;

    private String chatId;

    @Enumerated(EnumType.STRING)
    private Department department;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(columnDefinition = "boolean default false")
    private boolean active;

    @Column(columnDefinition = "boolean default false")
    private boolean block;

    @Enumerated(EnumType.STRING)
    private Language language;

}

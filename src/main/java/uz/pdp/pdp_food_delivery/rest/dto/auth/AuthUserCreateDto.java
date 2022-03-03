package uz.pdp.pdp_food_delivery.rest.dto.auth;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.pdp_food_delivery.rest.dto.BaseDto;

public class AuthUserCreateDto implements BaseDto {
    public String chatId;

    public AuthUserCreateDto(String chatId) {
        this.chatId = chatId;
    }
}

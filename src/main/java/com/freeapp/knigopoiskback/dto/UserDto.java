package com.freeapp.knigopoiskback.dto;

import com.freeapp.knigopoiskback.entity.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
        private String login;
        private String email;
        private String status;

        public static UserDto fromUser(AppUser user) {
                return new UserDto(user.getLogin(), user.getEmail(), user.getStatus().name());
        }
}

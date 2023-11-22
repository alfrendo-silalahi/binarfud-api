package com.binarfud.backend.dto.request.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RegisterBuyerReq {
    
    @NotEmpty(message = "username cannot be empty")
    private String username;

    @NotEmpty(message = "email cannot be empty")
    @Email(message = "must be email format")
    private String email;

    @NotEmpty(message = "password cannot be empty")
    private String password;

}

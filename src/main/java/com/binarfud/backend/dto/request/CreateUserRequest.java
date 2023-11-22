package com.binarfud.backend.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateUserRequest {

    @NotEmpty(message = "username cannot be empty")
    @NotNull(message = "username cannot be null")
    private String username;

    @NotEmpty(message = "emailAddress cannot be empty")
    @NotNull(message = "emailAddress cannot be null")
    private String emailAddress;

    @NotEmpty(message = "password cannot be empty")
    @NotNull(message = "password cannot be null")
    private String password;

}

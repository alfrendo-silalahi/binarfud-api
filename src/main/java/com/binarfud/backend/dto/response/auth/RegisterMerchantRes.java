package com.binarfud.backend.dto.response.auth;

import java.time.LocalDateTime;

import com.binarfud.backend.model.Role;

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
public class RegisterMerchantRes {

    private String username;

    private String email;

    private String password;

    private Role role;

    private String store;

    private String location;

    private boolean open;

    private LocalDateTime createdAt;
    
}

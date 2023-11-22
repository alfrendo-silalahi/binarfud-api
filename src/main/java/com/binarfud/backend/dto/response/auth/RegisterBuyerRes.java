package com.binarfud.backend.dto.response.auth;

import java.time.LocalDateTime;
import java.util.UUID;

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
public class RegisterBuyerRes {
    
    private UUID id;

    private String username;

    private String email;

    private Role role;

    private LocalDateTime createdAt;

}

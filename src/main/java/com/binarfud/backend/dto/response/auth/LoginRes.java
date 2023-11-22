package com.binarfud.backend.dto.response.auth;

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
public class LoginRes {
    
    private String jwt;

    private Role role;

}

package com.binarfud.backend.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.binarfud.backend.dto.request.auth.LoginReq;
import com.binarfud.backend.dto.request.auth.RegisterBuyerReq;
import com.binarfud.backend.dto.request.auth.RegisterMerchantReq;
import com.binarfud.backend.dto.response.auth.LoginRes;
import com.binarfud.backend.dto.response.auth.RegisterBuyerRes;
import com.binarfud.backend.dto.response.auth.RegisterMerchantRes;
import com.binarfud.backend.model.Merchant;
import com.binarfud.backend.model.Role;
import com.binarfud.backend.model.User;
import com.binarfud.backend.repository.MerchantRepository;
import com.binarfud.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class SimpleAuthService implements AuthService {

    private final UserRepository userRepository;

    private final MerchantRepository merchantRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    @Override
    public RegisterBuyerRes registerBuyer(RegisterBuyerReq registerBuyerReq) {
        log.info(registerBuyerReq.toString());
        User user = User.builder()
                .username(registerBuyerReq.getUsername())
                .email(registerBuyerReq.getEmail())
                .password(passwordEncoder.encode(registerBuyerReq.getPassword()))
                .role(Role.BUYER)
                .build();

        User newUser = userRepository.save(user);

        return RegisterBuyerRes.builder()
                .id(newUser.getId())
                .username(newUser.getUsername())
                .email(newUser.getPassword())
                .role(newUser.getRole())
                .createdAt(newUser.getCreatedAt())
                .build();
    }

    @Override
    public RegisterMerchantRes registerMerchant(RegisterMerchantReq registerMerchantReq) {
        Merchant merchant = Merchant.builder()
                .store(registerMerchantReq.getStore())
                .location(registerMerchantReq.getLocation())
                .open(true)
                .build();
        Merchant newMerchant = merchantRepository.save(merchant);
        
        User user = User.builder()
                .username(registerMerchantReq.getUsername())
                .email(registerMerchantReq.getEmail())
                .password(passwordEncoder.encode(registerMerchantReq.getPassword()))
                .role(Role.MERCHANT)
                .merchant(newMerchant)
                .build();
        User newUser = userRepository.save(user);
        
        return RegisterMerchantRes.builder()
                .username(newUser.getUsername())
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .role(newUser.getRole())
                .store(newUser.getMerchant().getStore())
                .location(newUser.getMerchant().getLocation())
                .open(newUser.getMerchant().isOpen())
                .createdAt(newUser.getCreatedAt())
                .build();
    }

    @Override
    public LoginRes login(LoginReq loginReq) {
        User user = userRepository.findByUsername(loginReq.getUsername())
                .orElseThrow(() -> new RuntimeException("user not found!"));

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginReq.getUsername(),
                loginReq.getPassword()
            )
        );

        String jwt = jwtService.generateToken(user);

        return LoginRes.builder()
                .jwt(jwt)
                .role(user.getRole())
                .build();
    }
    
}

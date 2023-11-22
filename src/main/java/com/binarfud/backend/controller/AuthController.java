package com.binarfud.backend.controller;

import com.binarfud.backend.dto.request.auth.LoginReq;
import com.binarfud.backend.dto.request.auth.RegisterBuyerReq;
import com.binarfud.backend.dto.request.auth.RegisterMerchantReq;
import com.binarfud.backend.dto.response.auth.LoginRes;
import com.binarfud.backend.dto.response.auth.RegisterBuyerRes;
import com.binarfud.backend.dto.response.auth.RegisterMerchantRes;
import com.binarfud.backend.security.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth")
@Slf4j
@Tag(
        name = "Authentication",
        description = ""
)
@RequiredArgsConstructor
public class AuthController {

    /*
    private final UserService userService;

    private final Map<String, Object> dataObj = new HashMap<>();

    @PostMapping("register")
    public ResponseEntity<BaseSuccessResponse<Map<String, Object>>> createUser(
            @RequestBody CreateUserRequest createUserRequest
    ) {
        log.info(createUserRequest.toString());

        CreateUserResponse data = userService.createUser(createUserRequest);

        dataObj.clear();
        dataObj.put("user", data);

        BaseSuccessResponse<Map<String, Object>> response = new BaseSuccessResponse<>();
        response.setCode(HttpStatus.CREATED.value());
        response.setStatus(ResponseStatus.SUCCESS.value());
        response.setData(dataObj);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(path = "{user-id}")
    public ResponseEntity<UpdateUserResponse> updateUser(
            @PathVariable(name = "user-id") UUID userId,
            @RequestBody UpdateUserRequest updateUserRequest
    ) {
        log.info("User id -> {}", userId);
        log.info("Update user request -> {}", updateUserRequest.toString());

        var response = userService.updateUser(userId, updateUserRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "{user-id}")
    public ResponseEntity<DeleteUserResponse> deleteUser(
            @PathVariable(name = "user-id") UUID userId
    ) {
        log.info("User id -> {}", userId);
        var response = userService.deleteUser(userId);
        return ResponseEntity.ok(response);
    }
    */

    private final AuthService authService;

    @PostMapping("/register/buyer")
    public ResponseEntity<RegisterBuyerRes> registerBuyer(@RequestBody RegisterBuyerReq registerBuyerReq) {
        return new ResponseEntity<>(authService.registerBuyer(registerBuyerReq), HttpStatus.CREATED);
    }

    @PostMapping("/register/merchant")
    public ResponseEntity<RegisterMerchantRes> registerMerchant(@RequestBody RegisterMerchantReq registerMerchantReq) {
        return new ResponseEntity<>(authService.registerMerchant(registerMerchantReq), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginRes> loginRes(@RequestBody LoginReq loginReq) {
        return new ResponseEntity<>(authService.login(loginReq), HttpStatus.OK);
    }

}

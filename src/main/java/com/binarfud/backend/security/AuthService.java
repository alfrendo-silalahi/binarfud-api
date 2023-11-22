package com.binarfud.backend.security;

import com.binarfud.backend.dto.request.auth.LoginReq;
import com.binarfud.backend.dto.request.auth.RegisterBuyerReq;
import com.binarfud.backend.dto.request.auth.RegisterMerchantReq;
import com.binarfud.backend.dto.response.auth.LoginRes;
import com.binarfud.backend.dto.response.auth.RegisterBuyerRes;
import com.binarfud.backend.dto.response.auth.RegisterMerchantRes;

public interface AuthService {
    
    RegisterBuyerRes registerBuyer(RegisterBuyerReq registerBuyerReq);

    RegisterMerchantRes registerMerchant(RegisterMerchantReq registerMerchantReq);

    LoginRes login(LoginReq loginReq);

}

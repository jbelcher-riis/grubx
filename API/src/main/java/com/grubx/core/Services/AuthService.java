package com.grubx.core.Services;

import java.io.UnsupportedEncodingException;

import com.grubx.core.Daos.UserDao;
import com.grubx.core.Dtos.LoginRequestDto;
import com.grubx.core.Dtos.LoginResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto loginRequest) throws UnsupportedEncodingException;

    UserDao getLoggedInUser();
}

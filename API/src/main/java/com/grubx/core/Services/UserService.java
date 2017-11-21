package com.grubx.core.Services;

import java.io.UnsupportedEncodingException;

import com.grubx.core.Dtos.LoginResponseDto;
import com.grubx.core.Dtos.NewUserDto;

public interface UserService {
    LoginResponseDto save(NewUserDto newUser) throws UnsupportedEncodingException;
}

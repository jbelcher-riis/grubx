package com.grubx.core.Services;

import com.grubx.core.Dtos.NewUserDto;
import com.grubx.core.Dtos.UserDto;

public interface UserService {
    UserDto save(NewUserDto newUser);
}

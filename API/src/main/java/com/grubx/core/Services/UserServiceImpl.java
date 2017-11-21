package com.grubx.core.Services;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grubx.core.Daos.UserDao;
import com.grubx.core.Dtos.LoginResponseDto;
import com.grubx.core.Dtos.NewUserDto;
import com.grubx.core.adapters.NewUserToUserAdapter;
import com.grubx.core.adapters.UserDaoToUserDtoAdapter;
import com.grubx.core.components.JwtCreator;
import com.grubx.core.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    NewUserToUserAdapter newUserToUserAdapter;

    @Autowired
    UserDaoToUserDtoAdapter userDaoToUserDtoAdapter;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtCreator jwtCreator;

    @Override
    public LoginResponseDto save(NewUserDto newUser) throws UnsupportedEncodingException {
	UserDao user = this.newUserToUserAdapter.convertToDao(newUser);

	user = this.userRepository.save(user);

	final LoginResponseDto response = new LoginResponseDto();
	response.setToken(jwtCreator.makeJwt(user));
	response.setUser(this.userDaoToUserDtoAdapter.convertToDto(user));

	return response;

    }

}

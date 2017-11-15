package com.grubx.core.Services;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.grubx.core.Daos.UserDao;
import com.grubx.core.Dtos.LoginRequestDto;
import com.grubx.core.Dtos.LoginResponseDto;
import com.grubx.core.Dtos.UserDto;
import com.grubx.core.adapters.UserDaoToUserDtoAdapter;
import com.grubx.core.components.EncoderFactory;
import com.grubx.core.components.JwtCreator;
import com.grubx.core.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EncoderFactory encoderFactory;

    @Autowired
    JwtCreator jwtCreator;

    @Autowired
    UserDaoToUserDtoAdapter userDaoToUserDtoAdapter;

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequest) throws UnsupportedEncodingException {
	final UserDao user = this.userRepository.findOneByEmail(loginRequest.getEmail());

	if (user == null) {
	    throw new BadCredentialsException("Invalid email or password");
	}

	if (!this.encoderFactory.makeEncoder().matches(loginRequest.getPassword(), user.getPassword())) {
	    throw new BadCredentialsException("Invalid email or password");
	}

	final UserDto userDto = this.userDaoToUserDtoAdapter.convertToDto(user);

	final LoginResponseDto response = new LoginResponseDto();
	response.setToken(jwtCreator.makeJwt(user));
	response.setUser(userDto);

	return response;
    }

    @Override
    public UserDao getLoggedInUser() {
	return (UserDao) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    }

}

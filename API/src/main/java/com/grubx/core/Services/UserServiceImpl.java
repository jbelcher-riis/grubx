package com.grubx.core.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grubx.core.Daos.UserDao;
import com.grubx.core.Dtos.NewUserDto;
import com.grubx.core.Dtos.UserDto;
import com.grubx.core.adapters.NewUserToUserAdapter;
import com.grubx.core.adapters.UserDaoToUserDtoAdapter;
import com.grubx.core.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    NewUserToUserAdapter newUserToUserAdapter;

    @Autowired
    UserDaoToUserDtoAdapter userDaoToUserDtoAdapter;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto save(NewUserDto newUser) {
	UserDao user = this.newUserToUserAdapter.convertToDao(newUser);

	user = this.userRepository.save(user);

	return this.userDaoToUserDtoAdapter.convertToDto(user);
    }

}

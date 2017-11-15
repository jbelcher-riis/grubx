package com.grubx.core.adapters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.grubx.core.Daos.UserDao;
import com.grubx.core.Dtos.UserDto;

@Component
public class UserDaoToUserDtoAdapter implements DaoToDtoAdapter<UserDao, UserDto> {

    @Override
    public List<UserDto> convertToDto(Collection<UserDao> dao) {
	return new ArrayList<UserDto>();
    }

    @Override
    public UserDto convertToDto(UserDao dao) {
	final UserDto dto = new UserDto();

	dto.setEmail(dao.getEmail());
	dto.setFirstName(dao.getFirstName());
	dto.setLastName(dao.getLastName());
	dto.setId(dao.getId());

	return dto;
    }

}

package com.grubx.core.adapters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grubx.core.Daos.UserDao;
import com.grubx.core.Dtos.NewUserDto;
import com.grubx.core.components.EncoderFactory;

@Component
public class NewUserToUserAdapter implements DtoToDaoAdapter<NewUserDto, UserDao> {

    @Autowired
    EncoderFactory encoderFactory;

    @Override
    public List<UserDao> convertToDao(Collection<NewUserDto> dto) {
	return new ArrayList<UserDao>();
    }

    @Override
    public UserDao convertToDao(NewUserDto dto) {
	final UserDao dao = new UserDao();

	dao.setEmail(dto.getEmail());
	dao.setFirstName(dto.getFirstName());
	dao.setLastName(dto.getLastName());
	dao.setPassword(this.encoderFactory.makeEncoder().encode(dto.getPassword()));
	dao.setCreatedAt(DateTime.now());
	dao.setLastModifiedAt(DateTime.now());
	dao.setCreatedBy("System");
	dao.setLastModifiedBy("System");

	return dao;
    }

}

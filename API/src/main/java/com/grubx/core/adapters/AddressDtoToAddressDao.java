package com.grubx.core.adapters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grubx.core.Daos.AddressDao;
import com.grubx.core.Dtos.AddressDto;
import com.grubx.core.Services.AuthService;

@Component
public class AddressDtoToAddressDao implements DtoToDaoAdapter<AddressDto, AddressDao> {

    @Autowired
    AuthService authService;

    @Override
    public List<AddressDao> convertToDao(Collection<AddressDto> dto) {
	return new ArrayList<AddressDao>();
    }

    @Override
    public AddressDao convertToDao(AddressDto dto) {
	final AddressDao dao = new AddressDao();
	dao.setAddress(dto.getAddress());
	dao.setCity(dto.getCity());
	dao.setCreatedBy(this.authService.getLoggedInUser().getEmail());
	dao.setCreatedAt(DateTime.now());
	dao.setLastModifiedAt(dao.getCreatedAt());
	dao.setLastModifiedBy(dao.getCreatedBy());
	dao.setState(dto.getState());
	dao.setSuite(dto.getSuite());
	dao.setZip(dto.getZip());

	return dao;
    }

}

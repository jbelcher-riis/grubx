package com.grubx.core.adapters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.grubx.core.Daos.AddressDao;
import com.grubx.core.Dtos.AddressDto;

@Component
public class AddressDaoToAddressDto implements DaoToDtoAdapter<AddressDao, AddressDto> {

    @Override
    public List<AddressDto> convertToDto(Collection<AddressDao> dao) {
	// TODO Auto-generated method stub
	return new ArrayList<AddressDto>();
    }

    @Override
    public AddressDto convertToDto(AddressDao dao) {
	final AddressDto dto = new AddressDto();

	dto.setId(dao.getId());
	dto.setAddress(dao.getAddress());
	dto.setCity(dao.getCity());
	dto.setState(dao.getState());
	dto.setSuite(dao.getSuite());
	dto.setZip(dao.getZip());

	return dto;
    }

}

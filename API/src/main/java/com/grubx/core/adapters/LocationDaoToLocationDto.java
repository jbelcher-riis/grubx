package com.grubx.core.adapters;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grubx.core.Daos.LocationDao;
import com.grubx.core.Dtos.LocationDto;

@Component
public class LocationDaoToLocationDto implements DaoToDtoAdapter<LocationDao, LocationDto> {

    @Autowired
    AddressDaoToAddressDto addressDaoToAddressDto;

    @Override
    public List<LocationDto> convertToDto(Collection<LocationDao> dao) {
	return dao.stream().map(d -> this.convertToDto(d)).collect(Collectors.toList());
    }

    @Override
    public LocationDto convertToDto(LocationDao dao) {
	final LocationDto dto = new LocationDto();

	dto.setAddress(addressDaoToAddressDto.convertToDto(dao.getAddress()));
	dto.setId(dao.getId());
	dto.setLatitude(dao.getLatitude());
	dto.setLongitude(dao.getLongitude());
	dto.setPhone(dao.getPhone());

	return dto;
    }

}

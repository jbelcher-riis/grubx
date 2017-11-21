package com.grubx.core.adapters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grubx.core.Daos.LocationDao;
import com.grubx.core.Dtos.LocationDto;
import com.grubx.core.Services.AuthService;

@Component
public class LocationDtoToLocationDao implements DtoToDaoAdapter<LocationDto, LocationDao> {

    @Autowired
    AuthService authService;

    @Override
    public List<LocationDao> convertToDao(Collection<LocationDto> dto) {
	return new ArrayList<LocationDao>();
    }

    @Override
    public LocationDao convertToDao(LocationDto dto) {
	final LocationDao dao = new LocationDao();

	dao.setCreatedAt(DateTime.now());
	dao.setCreatedBy(this.authService.getLoggedInUser().getEmail());
	dao.setLastModifiedAt(DateTime.now());
	dao.setLastModifiedBy(this.authService.getLoggedInUser().getEmail());
	dao.setLatitude(dto.getLatitude());
	dao.setLongitude(dto.getLongitude());
	dao.setPhone(dto.getPhone());
	dao.setEmail(dto.getEmail());
	dao.setName(dto.getName());

	return dao;
    }

}

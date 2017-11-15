package com.grubx.core.adapters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grubx.core.Daos.CompanyDao;
import com.grubx.core.Dtos.CompanyDto;
import com.grubx.core.Services.AuthService;

@Component
public class CompanyDtoToCompanyDao implements DtoToDaoAdapter<CompanyDto, CompanyDao> {

    @Autowired
    AddressDtoToAddressDao addressDtoToAddressDao;

    @Autowired
    AuthService authService;

    @Override
    public List<CompanyDao> convertToDao(Collection<CompanyDto> dto) {
	// TODO Auto-generated method stub
	return new ArrayList<CompanyDao>();
    }

    @Override
    public CompanyDao convertToDao(CompanyDto dto) {
	final CompanyDao dao = new CompanyDao();

	dao.setAdmin(authService.getLoggedInUser());
	dao.setCreatedAt(DateTime.now());
	dao.setCreatedBy(dao.getAdmin().getEmail());
	dao.setLastModifiedAt(DateTime.now());
	dao.setLastModifiedBy(dao.getAdmin().getEmail());
	dao.setName(dto.getName());
	dao.setPhone(dto.getPhone());

	return dao;
    }

}

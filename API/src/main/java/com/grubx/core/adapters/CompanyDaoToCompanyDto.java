package com.grubx.core.adapters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grubx.core.Daos.CompanyDao;
import com.grubx.core.Dtos.CompanyDto;

@Component
public class CompanyDaoToCompanyDto implements DaoToDtoAdapter<CompanyDao, CompanyDto> {

    @Autowired
    UserDaoToUserDtoAdapter userDaoToUserDtoAdapter;

    @Autowired
    AddressDaoToAddressDto addressDaoToAddressDto;

    @Override
    public List<CompanyDto> convertToDto(Collection<CompanyDao> dao) {
	// TODO Auto-generated method stub
	return new ArrayList<CompanyDto>();
    }

    @Override
    public CompanyDto convertToDto(CompanyDao dao) {
	final CompanyDto dto = new CompanyDto();

	dto.setAddress(this.addressDaoToAddressDto.convertToDto(dao.getAddress()));
	dto.setAdmin(this.userDaoToUserDtoAdapter.convertToDto(dao.getAdmin()));
	dto.setId(dao.getId());
	dto.setName(dao.getName());
	dto.setPhone(dao.getPhone());

	return dto;
    }

}

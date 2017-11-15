package com.grubx.core.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grubx.core.Daos.AddressDao;
import com.grubx.core.Dtos.AddressDto;
import com.grubx.core.adapters.AddressDtoToAddressDao;
import com.grubx.core.repositories.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AddressDtoToAddressDao addressDtoToAddressDao;

    @Override
    public AddressDao create(AddressDto addressDto) {
	AddressDao address = this.addressRepository.findOneByAddressAndCityAndZipAndSuiteAndState(
		addressDto.getAddress(), addressDto.getCity(), addressDto.getZip(), addressDto.getSuite(),
		addressDto.getState());

	if (address != null) {
	    return address;
	}

	address = this.addressDtoToAddressDao.convertToDao(addressDto);
	return this.addressRepository.save(address);
    }

}

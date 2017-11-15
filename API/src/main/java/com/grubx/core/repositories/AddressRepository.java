package com.grubx.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grubx.core.Daos.AddressDao;

@Repository
public interface AddressRepository extends CrudRepository<AddressDao, Long> {
    AddressDao findOneByAddressAndCityAndZipAndSuiteAndState(String address, String city, String zip, String suite,
	    String state);
}

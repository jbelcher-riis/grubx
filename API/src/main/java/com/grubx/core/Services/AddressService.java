package com.grubx.core.Services;

import com.grubx.core.Daos.AddressDao;
import com.grubx.core.Dtos.AddressDto;

public interface AddressService {
    AddressDao create(AddressDto addressDto);
}

package com.grubx.core.Services;

import java.util.List;

import com.grubx.core.Daos.CompanyDao;
import com.grubx.core.Dtos.CategoryDto;
import com.grubx.core.Dtos.CompanyDto;
import com.grubx.core.Dtos.LocationDto;
import com.grubx.core.Dtos.MenuItemDto;

public interface CompanyService {
    CompanyDto create(CompanyDto company);

    CompanyDao findOne(long companyId);

    CompanyDto findOneDto(long companyId);

    List<LocationDto> findLocations(long companyId);

    List<CategoryDto> findCategories(long companyId);

    List<MenuItemDto> findMenuItems(long companyId);

}

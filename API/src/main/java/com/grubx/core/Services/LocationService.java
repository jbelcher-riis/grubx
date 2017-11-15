package com.grubx.core.Services;

import java.util.List;

import com.grubx.core.Dtos.CategoryDto;
import com.grubx.core.Dtos.LocationDto;

public interface LocationService {
    LocationDto create(long companyId, LocationDto locationDto);

    void addCategory(long locationId, CategoryDto locationCategoryDto);

    List<CategoryDto> findCategories(long locationId);
}

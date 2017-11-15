package com.grubx.core.Services;

import com.grubx.core.Dtos.CategoryDto;

public interface CategoryService {

    CategoryDto create(long companyId, CategoryDto categoryDto);

}

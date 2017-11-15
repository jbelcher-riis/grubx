package com.grubx.core.adapters;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grubx.core.Daos.CategoryDao;
import com.grubx.core.Dtos.CategoryDto;

@Component
public class CategoryDaoToCategoryDto implements DaoToDtoAdapter<CategoryDao, CategoryDto> {

    @Autowired
    CompanyDaoToCompanyDto companyDaoToCompanyDto;

    @Override
    public List<CategoryDto> convertToDto(Collection<CategoryDao> dao) {
	return dao.stream().map(d -> this.convertToDto(d)).collect(Collectors.toList());
    }

    @Override
    public CategoryDto convertToDto(CategoryDao dao) {
	final CategoryDto dto = new CategoryDto();

	dto.setId(dao.getId());
	dto.setName(dao.getName());

	return dto;
    }

}

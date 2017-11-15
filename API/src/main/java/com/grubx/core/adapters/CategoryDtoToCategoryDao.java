package com.grubx.core.adapters;

import java.util.Collection;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grubx.core.Daos.CategoryDao;
import com.grubx.core.Dtos.CategoryDto;
import com.grubx.core.Services.AuthService;

@Component
public class CategoryDtoToCategoryDao implements DtoToDaoAdapter<CategoryDto, CategoryDao> {

    @Autowired
    AuthService authService;

    @Override
    public List<CategoryDao> convertToDao(Collection<CategoryDto> dto) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public CategoryDao convertToDao(CategoryDto dto) {
	final CategoryDao dao = new CategoryDao();
	dao.setCreatedAt(DateTime.now());
	dao.setCreatedBy(this.authService.getLoggedInUser().getEmail());
	dao.setLastModifiedAt(DateTime.now());
	dao.setLastModifiedBy(this.authService.getLoggedInUser().getEmail());
	dao.setName(dto.getName());

	return dao;
    }

}

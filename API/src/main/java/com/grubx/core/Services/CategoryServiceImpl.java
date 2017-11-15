package com.grubx.core.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.stereotype.Service;

import com.grubx.core.Daos.CategoryDao;
import com.grubx.core.Daos.CompanyDao;
import com.grubx.core.Daos.UserDao;
import com.grubx.core.Dtos.CategoryDto;
import com.grubx.core.adapters.CategoryDaoToCategoryDto;
import com.grubx.core.adapters.CategoryDtoToCategoryDao;
import com.grubx.core.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    AuthService authService;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CompanyService companyService;

    @Autowired
    CategoryDtoToCategoryDao categoryDtoToCategoryDao;

    @Autowired
    CategoryDaoToCategoryDto categoryDaoToCategoryDto;

    @Override
    public CategoryDto create(long companyId, CategoryDto categoryDto) {

	final UserDao loggedInUser = this.authService.getLoggedInUser();

	final CompanyDao company = this.companyService.findOne(companyId);

	if (!company.isAdmin(loggedInUser)) {
	    throw new InsufficientAuthenticationException("You do not have permission to do this");
	}

	CategoryDao category = this.categoryDtoToCategoryDao.convertToDao(categoryDto);
	category.setCompany(company);
	category = this.categoryRepository.save(category);

	return this.categoryDaoToCategoryDto.convertToDto(category);
    }

}

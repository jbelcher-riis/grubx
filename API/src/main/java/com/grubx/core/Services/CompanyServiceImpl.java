package com.grubx.core.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.stereotype.Service;

import com.grubx.core.Daos.CompanyDao;
import com.grubx.core.Daos.LocationDao;
import com.grubx.core.Daos.UserDao;
import com.grubx.core.Dtos.CategoryDto;
import com.grubx.core.Dtos.CompanyDto;
import com.grubx.core.Dtos.LocationDto;
import com.grubx.core.Dtos.MenuItemDto;
import com.grubx.core.adapters.CategoryDaoToCategoryDto;
import com.grubx.core.adapters.CompanyDaoToCompanyDto;
import com.grubx.core.adapters.CompanyDtoToCompanyDao;
import com.grubx.core.adapters.LocationDaoToLocationDto;
import com.grubx.core.adapters.MenuItemDaoToMenuItemDto;
import com.grubx.core.repositories.CompanyRepository;
import com.grubx.core.repositories.LocationRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyDtoToCompanyDao companyDtoToCompanyDao;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    AddressService addressService;

    @Autowired
    CompanyDaoToCompanyDto companyDaoToCompanyDto;

    @Autowired
    LocationDaoToLocationDto locationDaoToLocationDto;

    @Autowired
    AuthService authService;

    @Autowired
    CategoryDaoToCategoryDto categoryDaoToCategoryDto;

    @Autowired
    MenuItemDaoToMenuItemDto menuItemDaoToMenuItemDto;

    @Override
    public CompanyDto create(CompanyDto companyDto) {
	CompanyDao company = this.companyDtoToCompanyDao.convertToDao(companyDto);

	company.setAddress(this.addressService.create(companyDto.getAddress()));
	company = this.companyRepository.save(company);

	return companyDaoToCompanyDto.convertToDto(company);
    }

    @Override
    public CompanyDao findOne(long companyId) {
	return this.companyRepository.findOne(companyId);
    }

    @Override
    public List<LocationDto> findLocations(long companyId) {
	final CompanyDao company = this.companyRepository.findOne(companyId);

	final List<LocationDao> locations = this.locationRepository.findAllByCompany(company);

	return this.locationDaoToLocationDto.convertToDto(locations);
    }

    @Override
    public CompanyDto findOneDto(long companyId) {
	return this.companyDaoToCompanyDto.convertToDto(this.companyRepository.findOne(companyId));
    }

    @Override
    public List<CategoryDto> findCategories(long companyId) {
	final UserDao loggedInUser = this.authService.getLoggedInUser();

	final CompanyDao company = this.companyRepository.findOne(companyId);

	if (!company.isAdmin(loggedInUser)) {
	    throw new InsufficientAuthenticationException("You do not have permission to do this");
	}

	return this.categoryDaoToCategoryDto.convertToDto(company.getCategories());
    }

    @Override
    public List<MenuItemDto> findMenuItems(long companyId) {
	final UserDao loggedInUser = this.authService.getLoggedInUser();

	final CompanyDao company = this.companyRepository.findOne(companyId);

	if (!company.isAdmin(loggedInUser)) {
	    throw new InsufficientAuthenticationException("You do not have permission to do this");
	}

	return this.menuItemDaoToMenuItemDto.convertToDto(company.getMenuItems());
    }

}

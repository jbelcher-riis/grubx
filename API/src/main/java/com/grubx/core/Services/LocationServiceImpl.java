package com.grubx.core.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.stereotype.Service;

import com.grubx.core.Daos.CategoryDao;
import com.grubx.core.Daos.CompanyDao;
import com.grubx.core.Daos.LocationCategoryDao;
import com.grubx.core.Daos.LocationDao;
import com.grubx.core.Daos.UserDao;
import com.grubx.core.Dtos.CategoryDto;
import com.grubx.core.Dtos.LocationDto;
import com.grubx.core.adapters.CategoryDaoToCategoryDto;
import com.grubx.core.adapters.LocationDaoToLocationDto;
import com.grubx.core.adapters.LocationDtoToLocationDao;
import com.grubx.core.repositories.CategoryRepository;
import com.grubx.core.repositories.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    CompanyService companyService;

    @Autowired
    AuthService authService;

    @Autowired
    LocationDtoToLocationDao locationDtoToDao;

    @Autowired
    LocationDaoToLocationDto locationDaoToDto;

    @Autowired
    CategoryDaoToCategoryDto categoryDaoToCategoryDto;

    @Autowired
    AddressService addressService;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    LocationCategoryService locationCategoryService;

    @Override
    public LocationDto create(long companyId, LocationDto locationDto) {

	final UserDao loggedInUser = this.authService.getLoggedInUser();

	final CompanyDao company = this.companyService.findOne(companyId);

	if (!company.isAdmin(loggedInUser)) {
	    throw new InsufficientAuthenticationException("You do not have permission to do this");
	}

	LocationDao location = this.locationDtoToDao.convertToDao(locationDto);
	location.setCompany(company);
	location.setAddress(this.addressService.create(locationDto.getAddress()));

	location = this.locationRepository.save(location);

	return this.locationDaoToDto.convertToDto(location);
    }

    @Override
    public void addCategory(long locationId, CategoryDto categoryDto) {

	final UserDao loggedInUser = this.authService.getLoggedInUser();

	final LocationDao location = this.locationRepository.findOne(locationId);

	final CompanyDao company = this.companyService.findOne(location.getCompany().getId());

	if (!company.isAdmin(loggedInUser)) {
	    throw new InsufficientAuthenticationException("You do not have permission to do this");
	}

	final CategoryDao category = this.categoryRepository.findOne(categoryDto.getId());

	final LocationCategoryDao locationCategory = new LocationCategoryDao();
	locationCategory.setLocation(location);
	locationCategory.setCategory(category);
	locationCategory.setCreatedBy(loggedInUser.getEmail());
	locationCategory.setCreatedAt(DateTime.now());

	location.getLocationCategories().add(locationCategory);

	this.locationRepository.save(location);
    }

    @Override
    public List<CategoryDto> findCategories(long locationId) {

	final LocationDao location = this.locationRepository.findOne(locationId);

	final List<CategoryDao> categories = location.getLocationCategories().stream().map(lt -> lt.getCategory())
		.collect(Collectors.toList());

	return this.categoryDaoToCategoryDto.convertToDto(categories);
    }

}

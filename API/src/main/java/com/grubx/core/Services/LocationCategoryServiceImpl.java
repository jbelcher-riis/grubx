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
import com.grubx.core.Daos.LocationCategoryMenuItemDao;
import com.grubx.core.Daos.LocationDao;
import com.grubx.core.Daos.MenuItemDao;
import com.grubx.core.Daos.UserDao;
import com.grubx.core.Dtos.MenuItemDto;
import com.grubx.core.adapters.MenuItemDaoToMenuItemDto;
import com.grubx.core.repositories.CategoryRepository;
import com.grubx.core.repositories.LocationCategoryRepository;
import com.grubx.core.repositories.LocationRepository;
import com.grubx.core.repositories.MenuItemRepository;

@Service
public class LocationCategoryServiceImpl implements LocationCategoryService {

    @Autowired
    AuthService authService;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    CompanyService companyService;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    LocationCategoryRepository locationCategoryRepository;

    @Autowired
    MenuItemRepository menuItemRepository;

    @Autowired
    MenuItemDaoToMenuItemDto menuItemDaoToMenuItemDto;

    @Override
    public void addMenuItem(long locationId, long categoryId, MenuItemDto menuItemDto) {
	final UserDao loggedInUser = this.authService.getLoggedInUser();

	final LocationDao location = this.locationRepository.findOne(locationId);

	final CompanyDao company = this.companyService.findOne(location.getCompany().getId());

	if (!company.isAdmin(loggedInUser)) {
	    throw new InsufficientAuthenticationException("You do not have permission to do this");
	}

	final CategoryDao category = this.categoryRepository.findOne(categoryId);

	final LocationCategoryDao locationCategory = this.locationCategoryRepository
		.findOneByLocationAndCategory(location, category);

	final MenuItemDao menuItem = this.menuItemRepository.findOne(menuItemDto.getId());

	final LocationCategoryMenuItemDao lcmi = new LocationCategoryMenuItemDao();
	lcmi.setCreatedAt(DateTime.now());
	lcmi.setCreatedBy(loggedInUser.getEmail());
	lcmi.setLastModifiedAt(DateTime.now());
	lcmi.setLastModifiedBy(loggedInUser.getEmail());
	lcmi.setLocationCategory(locationCategory);
	lcmi.setMenuItem(menuItem);

	locationCategory.getLocationCategoryMenuItems().add(lcmi);

	this.locationCategoryRepository.save(locationCategory);
    }

    @Override
    public List<MenuItemDto> findMenuItems(long locationId, long categoryId) {
	final LocationDao location = this.locationRepository.findOne(locationId);
	final CategoryDao category = this.categoryRepository.findOne(categoryId);

	final LocationCategoryDao locationCategory = this.locationCategoryRepository
		.findOneByLocationAndCategory(location, category);

	final List<MenuItemDao> menuItems = locationCategory.getLocationCategoryMenuItems().stream()
		.map(lcmi -> lcmi.getMenuItem()).collect(Collectors.toList());

	return this.menuItemDaoToMenuItemDto.convertToDto(menuItems);
    }

}

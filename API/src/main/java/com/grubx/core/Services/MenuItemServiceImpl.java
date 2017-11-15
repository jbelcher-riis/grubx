package com.grubx.core.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.stereotype.Service;

import com.grubx.core.Daos.CompanyDao;
import com.grubx.core.Daos.MenuItemDao;
import com.grubx.core.Daos.UserDao;
import com.grubx.core.Dtos.MenuItemDto;
import com.grubx.core.adapters.MenuItemDaoToMenuItemDto;
import com.grubx.core.adapters.MenuItemDtoToMenuItemDao;
import com.grubx.core.repositories.MenuItemRepository;

@Service
public class MenuItemServiceImpl implements MenuItemService {
    @Autowired
    AuthService authService;

    @Autowired
    CompanyService companyService;

    @Autowired
    MenuItemDtoToMenuItemDao menuItemDtoToMenuItemDao;

    @Autowired
    MenuItemDaoToMenuItemDto menuItemDaoToMenuItemDto;

    @Autowired
    MenuItemRepository menuItemRepository;

    @Override
    public MenuItemDto create(long companyId, MenuItemDto menuItemDto) {
	final UserDao loggedInUser = this.authService.getLoggedInUser();

	final CompanyDao company = this.companyService.findOne(companyId);

	if (!company.isAdmin(loggedInUser)) {
	    throw new InsufficientAuthenticationException("You do not have permission to do this");
	}

	MenuItemDao menuItem = this.menuItemDtoToMenuItemDao.convertToDao(menuItemDto);
	menuItem.setCompany(company);

	menuItem = this.menuItemRepository.save(menuItem);

	return this.menuItemDaoToMenuItemDto.convertToDto(menuItem);
    }

}

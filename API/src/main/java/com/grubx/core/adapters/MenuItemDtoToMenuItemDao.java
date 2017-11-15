package com.grubx.core.adapters;

import java.util.Collection;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grubx.core.Daos.MenuItemDao;
import com.grubx.core.Dtos.MenuItemDto;
import com.grubx.core.Services.AuthService;

@Component
public class MenuItemDtoToMenuItemDao implements DtoToDaoAdapter<MenuItemDto, MenuItemDao> {

    @Autowired
    AuthService authService;

    @Override
    public List<MenuItemDao> convertToDao(Collection<MenuItemDto> dto) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public MenuItemDao convertToDao(MenuItemDto dto) {
	final MenuItemDao dao = new MenuItemDao();

	dao.setCreatedAt(DateTime.now());
	dao.setCreatedBy(this.authService.getLoggedInUser().getEmail());
	dao.setDescription(dto.getDescription());
	dao.setImage(dto.getImage());
	dao.setLastModifiedAt(DateTime.now());
	dao.setLastModifiedBy(this.authService.getLoggedInUser().getEmail());
	dao.setName(dto.getName());
	dao.setPrice(dto.getPrice());

	return dao;
    }

}

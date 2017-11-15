package com.grubx.core.adapters;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.grubx.core.Daos.MenuItemDao;
import com.grubx.core.Dtos.MenuItemDto;

@Component
public class MenuItemDaoToMenuItemDto implements DaoToDtoAdapter<MenuItemDao, MenuItemDto> {

    @Override
    public List<MenuItemDto> convertToDto(Collection<MenuItemDao> dao) {
	return dao.stream().map(d -> this.convertToDto(d)).collect(Collectors.toList());
    }

    @Override
    public MenuItemDto convertToDto(MenuItemDao dao) {
	final MenuItemDto dto = new MenuItemDto();

	dto.setDescription(dao.getDescription());
	dto.setId(dao.getId());
	dto.setImage(dao.getImage());
	dto.setName(dao.getName());
	dto.setPrice(dao.getPrice());

	return dto;
    }

}

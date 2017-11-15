package com.grubx.core.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grubx.core.Dtos.MenuItemDto;

@Service
public interface LocationCategoryService {
    void addMenuItem(long locationId, long categoryId, MenuItemDto menuItem);

    List<MenuItemDto> findMenuItems(long locationId, long categoryId);

}

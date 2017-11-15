package com.grubx.core.Services;

import com.grubx.core.Dtos.MenuItemDto;

public interface MenuItemService {
    MenuItemDto create(long companyId, MenuItemDto menuItemDto);
}

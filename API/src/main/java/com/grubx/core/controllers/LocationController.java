package com.grubx.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grubx.core.Dtos.CategoryDto;
import com.grubx.core.Dtos.MenuItemDto;
import com.grubx.core.Services.LocationCategoryService;
import com.grubx.core.Services.LocationService;

@RestController
@RequestMapping(value = "/api/v1/locations")
public class LocationController {

    @Autowired
    LocationService locationService;

    @Autowired
    LocationCategoryService locationCategoryService;

    @RequestMapping(value = "/{locationId}/categories", method = RequestMethod.POST)
    public @ResponseBody void create(@PathVariable long locationId, @RequestBody CategoryDto categoryDto) {
	locationService.addCategory(locationId, categoryDto);
    }

    @RequestMapping(value = "/{locationId}/categories/{categoryId}/menu-items", method = RequestMethod.POST)
    public @ResponseBody void addMenuItemForLocationCategory(@PathVariable long locationId,
	    @PathVariable long categoryId, @RequestBody MenuItemDto menuItemDto) {
	locationCategoryService.addMenuItem(locationId, categoryId, menuItemDto);
    }

    @RequestMapping(value = "/{locationId}/categories", method = RequestMethod.GET)
    public @ResponseBody List<CategoryDto> findCategories(@PathVariable long locationId) {
	return locationService.findCategories(locationId);
    }

    @RequestMapping(value = "/{locationId}/categories/{categoryId}/menu-items", method = RequestMethod.GET)
    public @ResponseBody List<MenuItemDto> findMenuItems(@PathVariable long locationId, @PathVariable long categoryId) {
	return locationCategoryService.findMenuItems(locationId, categoryId);
    }

}

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
import com.grubx.core.Dtos.CompanyDto;
import com.grubx.core.Dtos.LocationDto;
import com.grubx.core.Dtos.MenuItemDto;
import com.grubx.core.Services.CategoryService;
import com.grubx.core.Services.CompanyService;
import com.grubx.core.Services.LocationService;
import com.grubx.core.Services.MenuItemService;

@RestController
@RequestMapping(value = "/api/v1/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    LocationService locationService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    MenuItemService menuItemService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody CompanyDto create(@RequestBody CompanyDto companyDto) {
	return companyService.create(companyDto);
    }

    @RequestMapping(value = "/{companyId}/locations", method = RequestMethod.POST)
    public @ResponseBody LocationDto createLocation(@PathVariable long companyId,
	    @RequestBody LocationDto locationDto) {
	return locationService.create(companyId, locationDto);
    }

    @RequestMapping(value = "/{companyId}/categories", method = RequestMethod.POST)
    public @ResponseBody CategoryDto createCategory(@PathVariable long companyId,
	    @RequestBody CategoryDto categoryDto) {
	return categoryService.create(companyId, categoryDto);
    }

    @RequestMapping(value = "/{companyId}/menu-items", method = RequestMethod.POST)
    public @ResponseBody MenuItemDto createMenuItem(@PathVariable long companyId,
	    @RequestBody MenuItemDto menuItemDto) {
	return menuItemService.create(companyId, menuItemDto);
    }

    @RequestMapping(value = "/{companyId}/locations", method = RequestMethod.GET)
    public @ResponseBody List<LocationDto> findCompanyLocations(@PathVariable long companyId) {
	return this.companyService.findLocations(companyId);
    }

    @RequestMapping(value = "/{companyId}", method = RequestMethod.GET)
    public @ResponseBody CompanyDto findCompany(@PathVariable long companyId) {
	return this.companyService.findOneDto(companyId);
    }

    @RequestMapping(value = "/{companyId}/categories", method = RequestMethod.GET)
    public @ResponseBody List<CategoryDto> findCompanyCategories(@PathVariable long companyId) {
	return this.companyService.findCategories(companyId);
    }

    @RequestMapping(value = "/{companyId}/menu-items", method = RequestMethod.GET)
    public @ResponseBody List<MenuItemDto> findCompanyMenuItems(@PathVariable long companyId) {
	return this.companyService.findMenuItems(companyId);
    }

}

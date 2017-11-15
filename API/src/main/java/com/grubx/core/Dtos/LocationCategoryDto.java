package com.grubx.core.Dtos;

public class LocationCategoryDto {
    LocationDto location;
    CategoryDto category;

    public LocationDto getLocation() {
	return location;
    }

    public void setLocation(LocationDto location) {
	this.location = location;
    }

    public CategoryDto getCategory() {
	return category;
    }

    public void setCategory(CategoryDto category) {
	this.category = category;
    }

}

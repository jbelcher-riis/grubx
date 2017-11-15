package com.grubx.core.Daos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "location_category_menu_item")
public class LocationCategoryMenuItemDao extends BaseDao implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "location_category_id")
    private LocationCategoryDao locationCategory;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item_id")
    private MenuItemDao menuItem;

    public LocationCategoryDao getLocationCategory() {
	return locationCategory;
    }

    public void setLocationCategory(LocationCategoryDao locationCategory) {
	this.locationCategory = locationCategory;
    }

    public MenuItemDao getMenuItem() {
	return menuItem;
    }

    public void setMenuItem(MenuItemDao menuItem) {
	this.menuItem = menuItem;
    }

    @Override
    public String toString() {
	return "LocationCategoryMenuItemDao [locationCategory=" + locationCategory + ", menuItem=" + menuItem + "]";
    }

}

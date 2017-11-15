package com.grubx.core.Daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "company")
public class CompanyDao extends BaseDao {

    private static final long serialVersionUID = -9130772378157969450L;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_id")
    private AddressDao address;

    @OneToOne(cascade = CascadeType.MERGE)
    private UserDao admin;

    private String phone;

    private String name;

    @OneToMany
    @JoinColumn(name = "company_id")
    private List<LocationDao> locations;

    @OneToMany
    @JoinColumn(name = "company_id")
    private List<CategoryDao> categories;

    @OneToMany
    @JoinColumn(name = "company_id")
    private List<MenuItemDao> menuItems;

    public AddressDao getAddress() {
	return address;
    }

    public void setAddress(AddressDao address) {
	this.address = address;
    }

    public UserDao getAdmin() {
	return admin;
    }

    public void setAdmin(UserDao admin) {
	this.admin = admin;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<LocationDao> getLocations() {
	return new ArrayList<LocationDao>(locations);
    }

    public void setLocations(List<LocationDao> locations) {
	this.locations = new ArrayList<LocationDao>(locations);
    }

    @Transient
    public boolean isAdmin(UserDao user) {
	return user.getId() == this.getAdmin().getId();
    }

    public List<CategoryDao> getCategories() {
	return categories;
    }

    public void setCategories(List<CategoryDao> categories) {
	this.categories = categories;
    }

    public List<MenuItemDao> getMenuItems() {
	return menuItems;
    }

    public void setMenuItems(List<MenuItemDao> menuItems) {
	this.menuItems = menuItems;
    }

    @Override
    public String toString() {
	return "CompanyDao [address=" + address + ", admin=" + admin + ", phone=" + phone + ", name=" + name
		+ ", locations=" + locations + "]";
    }

}

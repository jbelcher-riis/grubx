package com.grubx.core.Daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class LocationDao extends BaseDao implements Serializable {

    private static final long serialVersionUID = -5747637728336354275L;

    private String phone;
    private String latitude;
    private String longitude;
    private String name;
    private String email;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private final List<LocationCategoryDao> locationCategories = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyDao company;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_id")
    private AddressDao address;

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getLatitude() {
	return latitude;
    }

    public void setLatitude(String latitude) {
	this.latitude = latitude;
    }

    public String getLongitude() {
	return longitude;
    }

    public void setLongitude(String longitude) {
	this.longitude = longitude;
    }

    public CompanyDao getCompany() {
	return company;
    }

    public void setCompany(CompanyDao company) {
	this.company = company;
    }

    public AddressDao getAddress() {
	return address;
    }

    public void setAddress(AddressDao address) {
	this.address = address;
    }

    public List<LocationCategoryDao> getLocationCategories() {
	return locationCategories;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    @Override
    public String toString() {
	return "LocationDao [phone=" + phone + ", latitude=" + latitude + ", longitude=" + longitude + ", name=" + name
		+ ", email=" + email + ", locationCategories=" + locationCategories + ", company=" + company
		+ ", address=" + address + "]";
    }

}

package com.grubx.core.Dtos;

public class CompanyDto {
    private long id;
    private AddressDto address;
    private String phone;
    private String name;
    private UserDto admin;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public AddressDto getAddress() {
	return address;
    }

    public void setAddress(AddressDto address) {
	this.address = address;
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

    public UserDto getAdmin() {
	return admin;
    }

    public void setAdmin(UserDto admin) {
	this.admin = admin;
    }
}

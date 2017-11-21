package com.grubx.core.Dtos;

public class LocationDto {
    private long id;
    private String phone;
    private String latitude;
    private String longitude;
    private AddressDto address;
    private String name;
    private String email;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

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

    public AddressDto getAddress() {
	return address;
    }

    public void setAddress(AddressDto address) {
	this.address = address;
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

}

package com.grubx.core.Daos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "menu_item")
public class MenuItemDao extends BaseDao {

    private String name;
    private String description;
    private double price;
    private String image;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyDao company;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public String getImage() {
	return image;
    }

    public void setImage(String image) {
	this.image = image;
    }

    public CompanyDao getCompany() {
	return company;
    }

    public void setCompany(CompanyDao company) {
	this.company = company;
    }

}

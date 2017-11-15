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
@Table(name = "category")
public class CategoryDao extends BaseDao implements Serializable {

    private static final long serialVersionUID = 4333273932609355276L;

    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyDao company;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<LocationCategoryDao> locationCategories = new ArrayList<>();

    public List<LocationCategoryDao> getLocationCategories() {
	return this.locationCategories;
    }

    public void setLocationCategories(List<LocationCategoryDao> locationCategories) {
	this.locationCategories = new ArrayList<>(locationCategories);
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public CompanyDao getCompany() {
	return company;
    }

    public void setCompany(CompanyDao company) {
	this.company = company;
    }

    @Override
    public String toString() {
	return "CategoryDao [name=" + name + ", company=" + company + ", locationCategories=" + locationCategories
		+ "]";
    }

}

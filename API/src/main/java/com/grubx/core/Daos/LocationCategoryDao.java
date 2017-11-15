package com.grubx.core.Daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.grubx.core.components.TimestampConverter;

@Entity
@Table(name = "location_category")
public class LocationCategoryDao implements Serializable {

    private static final long serialVersionUID = 8621710019608080499L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "location_id")
    private LocationDao location;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryDao category;

    @Column(name = "created_at")
    @Convert(converter = TimestampConverter.class)
    private DateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuItem")
    private final List<LocationCategoryMenuItemDao> locationCategoryMenuItems = new ArrayList<>();

    public DateTime getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
	this.createdAt = createdAt;
    }

    public String getCreatedBy() {
	return createdBy;
    }

    public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
    }

    public LocationDao getLocation() {
	return location;
    }

    public void setLocation(LocationDao location) {
	this.location = location;
    }

    public CategoryDao getCategory() {
	return category;
    }

    public void setCategory(CategoryDao category) {
	this.category = category;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public List<LocationCategoryMenuItemDao> getLocationCategoryMenuItems() {
	return locationCategoryMenuItems;
    }

    @Override
    public String toString() {
	return "LocationCategoryDao [id=" + id + ", location=" + location + ", category=" + category + ", createdAt="
		+ createdAt + ", createdBy=" + createdBy + ", locationCategoryMenuItems=" + locationCategoryMenuItems
		+ "]";
    }

}

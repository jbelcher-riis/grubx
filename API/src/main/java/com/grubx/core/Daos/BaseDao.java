package com.grubx.core.Daos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.joda.time.DateTime;

import com.grubx.core.components.TimestampConverter;

@MappedSuperclass
public class BaseDao implements Serializable {

    private static final long serialVersionUID = -4010895822710296551L;

    @Column(name = "created_at")
    @Convert(converter = TimestampConverter.class)
    private DateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "last_modified_at")
    @Convert(converter = TimestampConverter.class)
    private DateTime lastModifiedAt;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    public DateTime getCreatedAt() {
	return createdAt;
    }

    public String getCreatedBy() {
	return createdBy;
    }

    public long getId() {
	return id;
    }

    public DateTime getLastModifiedAt() {
	return lastModifiedAt;
    }

    public String getLastModifiedBy() {
	return lastModifiedBy;
    }

    public void setCreatedAt(DateTime createdAt) {
	this.createdAt = createdAt;
    }

    public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
    }

    public void setId(long id) {
	this.id = id;
    }

    public void setLastModifiedAt(DateTime lastModifiedAt) {
	this.lastModifiedAt = lastModifiedAt;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
	this.lastModifiedBy = lastModifiedBy;
    }
}

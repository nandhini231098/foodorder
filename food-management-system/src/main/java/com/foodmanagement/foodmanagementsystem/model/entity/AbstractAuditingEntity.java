package com.foodmanagement.foodmanagementsystem.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Auditing entity class for createdDate and updatedDate.
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdDate", "updatedDate"}, allowGetters = true)
public abstract class AbstractAuditingEntity implements Serializable {

    /** The Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** Entity/Record created date. */
    @Column(name = "created_date", updatable = false)
    @NotNull
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    /** Entity/Record updated date. */
    @Column(name = "updated_date")
    @NotNull
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    
    public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


}

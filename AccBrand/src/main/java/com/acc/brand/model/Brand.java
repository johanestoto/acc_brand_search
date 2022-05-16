package com.acc.brand.model;

import java.sql.Timestamp;

import javax.persistence.*;
 

@Entity
@Table(name = "brand")
public class Brand {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="cd_brand")
	private String cdBrand;
	
	@Column(name="desc_brand")
	private String descBrand;
	
	private Timestamp created_date;
	
	private Timestamp last_modified_date;
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCdBrand() {
        return cdBrand;
    }

    public void setCd_brand(String cdBrand) {
        this.cdBrand = cdBrand;
    }

    public String getDescBrand() {
        return descBrand;
    }

    public void setDesc_brand(String descBrand) {
        this.descBrand = descBrand;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public Timestamp getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(Timestamp last_modified_date) {
        this.last_modified_date = last_modified_date;
    }
	
}

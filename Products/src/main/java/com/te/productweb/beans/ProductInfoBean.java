package com.te.productweb.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="product_info")
public class ProductInfoBean {
   
	@Id
	@Column
	private int id;
	@Column
	private String pname;
	@Column
	private Date myDate;
	@Column
	private Date exDate;
	@Column
	private double price;
	@Column
	private int quantity;
	@Column
	private String accessType;
}

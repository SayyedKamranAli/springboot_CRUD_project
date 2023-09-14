  package com.kamran.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Transient
	public static final String SEQUENCE_NAME="user_sequence";
    @Id
	private Long prodId;
    private String prodName;
    private double price;
    private String desc;
	public Long getProdId() {
		// TODO Auto-generated method stub
		return prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setprodId(Long prodId) {
		// TODO Auto-generated method stub
		this.prodId = prodId;
		
	}
}

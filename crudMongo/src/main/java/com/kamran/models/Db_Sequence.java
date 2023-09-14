package com.kamran.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "db_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Db_Sequence {
	
	

	@Id
	private String prodId;
	private Long seq;
	
	 public String getprodId() {
	        return prodId;
	    }

	    public void setprodId(String prodId) {
	        this.prodId = prodId;
	    }
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
}

package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier {

	@Id
	@GeneratedValue
	int suppid;
	String suppliername;
	int catid;
	public int getSuppid() {
		return suppid;
	}
	public void setSuppid(int suppid) {
		this.suppid = suppid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
}

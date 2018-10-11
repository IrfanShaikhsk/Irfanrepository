package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Orders 
{
	@Id
	@GeneratedValue
	private int orderId;
	
	private int purchaseValue;
	private Date orderDate;
	private String username;
	private String paymentMode;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getPurchaseValue() {
		return purchaseValue;
	}
	public void setPurchaseValue(int purchaseValue) {
		this.purchaseValue = purchaseValue;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public String getPaymentMode() 
	{
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) 
	{
		this.paymentMode = paymentMode;
	}	
}
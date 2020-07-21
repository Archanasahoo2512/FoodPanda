package com.foodDeliverySystem.bean;

import java.util.List;

public class Order extends Customer{

	private String orderId;
	private List<Object> orderItems;
	private Double totalPrice;
	
	
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public List<Object> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<Object> orderItems) {
		this.orderItems = orderItems;
	}

	
	
}

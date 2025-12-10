package com.wipro.ris.entity;

public class RefillRecord {
	private String refillId;
	private String ingredientId;
	private double qtyAdded;
	private String supplierName;
	private String date;	
	public RefillRecord(String refillId, String ingredientId, double qtyAdded, String supplierName, String date) {
		this.refillId = refillId;
		this.ingredientId = ingredientId;
		this.qtyAdded = qtyAdded;
		this.supplierName = supplierName;
		this.date = date;
	}
	public String getRefillId() {
		return refillId;
	}
	public void setRefillId(String refillId) {
		this.refillId = refillId;
	}
	public String getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(String ingredientId) {
		this.ingredientId = ingredientId;
	}
	public double getQtyAdded() {
		return qtyAdded;
	}
	public void setQtyAdded(double qtyAdded) {
		this.qtyAdded = qtyAdded;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}

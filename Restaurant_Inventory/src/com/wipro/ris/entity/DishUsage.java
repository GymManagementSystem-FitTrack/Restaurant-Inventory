package com.wipro.ris.entity;

public class DishUsage {
	private String usageId;
	private String ingredientId;
	private double qtyUsed;
	private String date;
	private String dishName;	
	public DishUsage(String usageId, String ingredientId, double qtyUsed, String date, String dishName){
		this.usageId = usageId;
		this.ingredientId = ingredientId;
		this.qtyUsed = qtyUsed;
		this.date = date;
		this.dishName = dishName;
	}
	public String getUsageId() {
		return usageId;
	}
	public void setUsageId(String usageId) {
		this.usageId = usageId;
	}
	public String getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(String ingredientId) {
		this.ingredientId = ingredientId;
	}
	public double getQtyUsed() {
		return qtyUsed;
	}
	public void setQtyUsed(double qtyUsed) {
		this.qtyUsed = qtyUsed;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

}

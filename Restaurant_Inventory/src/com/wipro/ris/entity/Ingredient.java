package com.wipro.ris.entity;

public class Ingredient {
	private String ingredientId;
	private String name;
	private String unit;
	private double availableQty;
	private double minRequiredQty;
	public Ingredient(String ingredientId, String name, String unit, double availableQty, double minRequiredQty) {
		this.ingredientId = ingredientId;
		this.name = name;
		this.unit = unit;
		this.availableQty = availableQty;
		this.minRequiredQty = minRequiredQty;
	}
	public String getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(String ingredientId) {
		this.ingredientId = ingredientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(double availableQty) {
		this.availableQty = availableQty;
	}
	public double getMinRequiredQty() {
		return minRequiredQty;
	}
	public void setMinRequiredQty(double minRequiredQty) {
		this.minRequiredQty = minRequiredQty;
	}


}

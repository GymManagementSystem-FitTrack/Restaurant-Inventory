package com.wipro.ris.service;
import java.util.ArrayList;
import com.wipro.ris.entity.DishUsage;
import com.wipro.ris.entity.Ingredient;
import com.wipro.ris.entity.RefillRecord;
import com.wipro.ris.util.IngredientNotFoundException;
import com.wipro.ris.util.InvalidStockOperationException;
import com.wipro.ris.util.RefillRecordException;

public class InventoryService {
	private ArrayList<Ingredient> ingredients;
	private ArrayList<DishUsage> usageLogs;
	private ArrayList<RefillRecord> refillLogs;
	public InventoryService(ArrayList<Ingredient> ingredients, ArrayList<DishUsage> usageLogs,
			ArrayList<RefillRecord> refillLogs) {
		this.ingredients = ingredients;
		this.usageLogs = usageLogs;
		this.refillLogs = refillLogs;
	}
	public Ingredient findIngredient(String ingredientId) throws IngredientNotFoundException {
		for (Ingredient ingredient : ingredients) {
			if (ingredient.getIngredientId().equals(ingredientId)) {
				return ingredient;
			}
		}
		throw new IngredientNotFoundException("Ingredient not found.");
	}
	public void addIngredient(Ingredient i) {
		ingredients.add(i);
	}
	public void recordUsage(String usageId, String ingredientId, double qty, String date, String dishName)
			throws IngredientNotFoundException, InvalidStockOperationException {
		Ingredient ingredient = findIngredient(ingredientId);
		if (qty <= 0) {
			throw new InvalidStockOperationException("Quantity must be positive");
		}
		if (ingredient.getAvailableQty() < qty) {
			throw new InvalidStockOperationException("Not enough to use");
		}
		ingredient.setAvailableQty(ingredient.getAvailableQty() - qty);
		DishUsage usage = new DishUsage(usageId, ingredientId, qty, date, dishName);
		usageLogs.add(usage);
	}
	public void refillStock(String refillId, String ingredientId, double qtyAdded, 
            String supplierName, String date) throws IngredientNotFoundException, RefillRecordException {
        Ingredient ingredient = findIngredient(ingredientId);
        if (qtyAdded <= 0) {
        	throw new RefillRecordException("Quantity must be positive");
        }
        ingredient.setAvailableQty(ingredient.getAvailableQty() + qtyAdded);
        RefillRecord refill = new RefillRecord(refillId, ingredientId, qtyAdded, supplierName, date);
        refillLogs.add(refill);
	}
	public ArrayList<DishUsage> getUsageHistory(String ingredientId) {
		ArrayList<DishUsage> list = new ArrayList<>();

		for (DishUsage d : usageLogs) {
			if (d.getIngredientId().equalsIgnoreCase(ingredientId)) {
				list.add(d);
			}
		}
		return list;
	}
	public ArrayList<Ingredient> getLowStockIngredients() {
		ArrayList<Ingredient> lowList = new ArrayList<>();

		for (Ingredient i : ingredients) {
			if (i.getAvailableQty() < i.getMinRequiredQty()) {
				lowList.add(i);
			}
		}
		return lowList;
	}
	public String generateInventorySummary() {
		StringBuilder sb = new StringBuilder();
		sb.append("INVENTORY SUMMARY\n\n");
		sb.append("Ingredient Details:\n");
		for (Ingredient ing : ingredients) {
			String status = "OK";
			if (ing.getAvailableQty() < ing.getMinRequiredQty()) {
				status = "LOW STOCK";
			}
			sb.append("Name: ").append(ing.getName())
			  .append(", Available: ").append(ing.getAvailableQty())
			  .append(", Min Required: ").append(ing.getMinRequiredQty())
			  .append(", Status: ").append(status)
			  .append("\n");
		}
		sb.append("\nUsage Logs:\n");
		for (DishUsage u : usageLogs) {
			sb.append("UsageID: ").append(u.getUsageId())
			  .append(", Ingredient: ").append(u.getIngredientId())
			  .append(", Qty Used: ").append(u.getQtyUsed())
			  .append(", Dish: ").append(u.getDishName())
			  .append(", Date: ").append(u.getDate())
			  .append("\n");
		}
		sb.append("\nRefill Logs:\n");
		for (RefillRecord r : refillLogs) {
			sb.append("RefillID: ").append(r.getRefillId())
			  .append(", Ingredient: ").append(r.getIngredientId())
			  .append(", Qty Added: ").append(r.getQtyAdded())
			  .append(", Supplier: ").append(r.getSupplierName())
			  .append(", Date: ").append(r.getDate())
			  .append("\n");
		}
		return sb.toString();
	}
}


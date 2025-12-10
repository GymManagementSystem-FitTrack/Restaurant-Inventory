package com.wipro.ris.main;
import java.util.ArrayList; 
import com.wipro.ris.entity.*; 
import com.wipro.ris.service.InventoryService; 


public class Main {
	public static void main(String[] args) { 
        ArrayList<Ingredient> ingredients = new ArrayList<>(); 
        ingredients.add(new Ingredient("ING001", "Rice", "kg", 50, 20)); 
        ingredients.add(new Ingredient("ING002", "Tomato", "kg", 12, 10)); 
        ArrayList<DishUsage> usageLogs = new ArrayList<>(); 
        ArrayList<RefillRecord> refillLogs = new ArrayList<>();  
        InventoryService service = new InventoryService(ingredients, usageLogs, refillLogs); 
        try {    
            service.recordUsage("U001", "ING001", 5, "2025-08-12", "Veg Biryani"); 
            service.refillStock("R001", "ING002", 15, "FreshFarm Supplier", "2025-08-12"); 
            System.out.println(service.generateInventorySummary()); 
        } catch (Exception e) { 
            System.out.println(e); 
        } 
    } 

}

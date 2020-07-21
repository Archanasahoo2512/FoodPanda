package com.foodDeliverySystem.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.foodDeliverySystem.bean.Resturant;
import com.foodDeliverySystem.dao.FoodDeliveryDao;
import com.sun.org.apache.xpath.internal.axes.HasPositionalPredChecker;

public class FoodDeliveryImpl implements FoodDeliveryDao{
	
	public Resturant loadRestaurantList(Resturant rest){
		ArrayList<Resturant> restaurant=new ArrayList<Resturant>();
		Resturant obj1=new Resturant();
		obj1.setRestaurantId("1");
		obj1.setRestaurantName("Thalapaktti");
		obj1.setTypee("South Indian, North Indian, Chinese");
		restaurant.add(obj1);
		Resturant obj2=new Resturant();
		obj2.setRestaurantId("2");
		obj2.setRestaurantName("BBQ Nation");
		obj2.setTypee("Italian, Thai");
		restaurant.add(obj2);
		rest.setRestaurantList(restaurant);
		return rest;
	}
	
	public Resturant loadRestaurantListRatingWise(Resturant rest){
		ArrayList<Resturant> restaurant=new ArrayList<Resturant>();
		Resturant obj1=new Resturant();
		
		Resturant obj2=new Resturant();
		obj2.setRestaurantName("Sarvana Bhavan");
		obj2.setTypee("South Indian, North Indian, Chinese");
		restaurant.add(obj2);
		obj1.setRestaurantName("Gupta Bhavan");
		obj1.setTypee("North Indian");
		restaurant.add(obj1);
		rest.setRestaurantList(restaurant);
		return rest;
	}
	
	public Resturant loadRestaurantItems(Resturant rest, String var){
		Map<String, Double> foodItems=new HashMap<String,Double>();
		Resturant obj1=new Resturant();
		System.out.println("type--"+rest.getTypee());
		if(rest.getTypee().equals("South Indian, North Indian, Chinese")){
		foodItems.put("Chicken Biryani", 200.0);
		foodItems.put("Mutton Biryani", 270.0);
		foodItems.put("Chicken 65 Biryani", 240.0);
		foodItems.put("Veg Biryani", 150.0);
		foodItems.put("Plain Dosa", 70.0);
		foodItems.put("Masala Dosa", 90.0);
		}else if(rest.getTypee().equals("Italian, Thai"))
		{
		foodItems.put("Veg Soups", 115.0);
		foodItems.put("Veg Lemon Chili Coriander Soup", 139.0);
		foodItems.put("Chicken Manchurian", 289.0);
		foodItems.put("Chicken Momo(6 Pcs)", 273.0);
		foodItems.put("Drums of Heaven", 289.0);
		foodItems.put("Veg Fried Wonton", 161.0);
		}else if(rest.getTypee().equals("Italian, Thai"))
		{
		foodItems.put("Veg Soups", 115.0);
		foodItems.put("Veg Lemon Chili Coriander Soup", 139.0);
		foodItems.put("Chicken Manchurian", 289.0);
		foodItems.put("Chicken Momo(6 Pcs)", 273.0);
		foodItems.put("Drums of Heaven", 289.0);
		foodItems.put("Veg Fried Wonton", 161.0);
		}else if(rest.getTypee().equals("North Indian"))
		{
		foodItems.put("Tandoori Roti(1 Pcs)", 60.0);
		foodItems.put("Naan(1 Pcs)", 70.0);
		foodItems.put("Butter Naan(1 Pcs)", 75.0);
		foodItems.put("Paneer Butter Masala", 150.0);
		foodItems.put("Mushroom Masala", 170.0);
		foodItems.put("Gulab Jamun(1 Pcs)", 30.0);
		}
		
		rest.setFoodItems(foodItems);
		if(var.equals("load")){
			Double sum=0.0;
			Map<String, Double> orderedfoodItems=new HashMap<String,Double>();
			List<Object> list=rest.getOrderItems();
			for (int i = 0; i < list.size(); i++) {
	            if(foodItems.containsKey(list.get(i))){
	            	orderedfoodItems.put((String) list.get(i), foodItems.get(list.get(i)));
	            	sum=sum+foodItems.get(list.get(i));
	            }
	        }
			System.out.println("sum--"+sum);
			rest.setTotalPrice(sum);
			rest.setFoodItems(orderedfoodItems);
		}
		return rest;
	}
}

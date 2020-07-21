package com.foodDeliverySystem.bean;


import java.util.List;
import java.util.Map;

public class Resturant extends Order{

		//private HashMap<String, Integer> restaurantName;
		private String restaurantName;
		private String restaurantId;
		private String Location;
		private String typee;
		private int restaurantRating;
		private Map<String, Double> foodItems;
		private List<Resturant> RestaurantList;	
		
		
		
		public Map<String, Double> getFoodItems() {
			return foodItems;
		}
		public void setFoodItems(Map<String, Double> foodItems) {
			this.foodItems = foodItems;
		}
		public int getRestaurantRating() {
			return restaurantRating;
		}
		public void setRestaurantRating(int restaurantRating) {
			this.restaurantRating = restaurantRating;
		}
		
		
		
		public String getRestaurantId() {
			return restaurantId;
		}
		public void setRestaurantId(String restaurantId) {
			this.restaurantId = restaurantId;
		}
		public String getTypee() {
			return typee;
		}
		public void setTypee(String typee) {
			this.typee = typee;
		}
		public List<Resturant> getRestaurantList() {
			return RestaurantList;
		}
		public void setRestaurantList(List<Resturant> restaurantList) {
			RestaurantList = restaurantList;
		}
		public String getLocation() {
			return Location;
		}
		public void setLocation(String location) {
			Location = location;
		}
		
		public String getRestaurantName() {
			return restaurantName;
		}
		public void setRestaurantName(String restaurantName) {
			this.restaurantName = restaurantName;
		}
		
		
}

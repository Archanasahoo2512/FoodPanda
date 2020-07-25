package com.foodDeliverySystem.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.foodDeliverySystem.bean.Resturant;
@Component
public interface FoodDeliveryDao {

		public Resturant loadRestaurantList(Resturant rest);
		public Resturant loadRestaurantListRatingWise(Resturant rest);
		public Resturant loadRestaurantItems(Resturant rest, String var);

		
}

package com.foodDeliverySystem.controller;





import javax.servlet.http.HttpSession;




import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodDeliverySystem.bean.Customer;
import com.foodDeliverySystem.bean.Order;
import com.foodDeliverySystem.bean.Resturant;
import com.foodDeliverySystem.daoImpl.FoodDeliveryImpl;


@Controller
public class FoodController {
	
	/*@Autowired
    private Customer cust;
	
	@Autowired
    private Resturant rest;*/

	FoodDeliveryImpl foodImpl;
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView mv=new ModelAndView("Login");
		return mv;
	}
	
	@RequestMapping(value="/loginSubmit", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView loginSuccess(@ModelAttribute("Customer") Customer cust, BindingResult result, HttpSession session){
		
		ModelAndView mv=new ModelAndView();
		if(result.hasErrors()){
			 mv =new ModelAndView();
			 mv.setViewName("Login");
			return mv;
		}else{
		System.out.println("mobile--"+cust.getMobileNumber());
		session.setAttribute("userMobile", cust.getMobileNumber());
		 mv.setViewName("FoodDeliveryDashboard");
		 mv.addObject("mobile", cust.getMobileNumber());
		return mv;
		}
	}
/*	@RequestMapping(value="/loginSubmit/{num}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView loginSuccess(@PathVariable("num") String num, @ModelAttribute("Customer") Customer cust, BindingResult result, HttpSession session){
		
		ModelAndView mv=new ModelAndView();
		if(result.hasErrors()){
			 mv =new ModelAndView();
			 mv.setViewName("Login");
			return mv;
		}else{
		System.out.println("mobile--"+num.substring(4).trim());
		session.setAttribute("userMobile", cust.getMobileNumber());
		 mv.setViewName("FoodDeliveryDashboard");
		 mv.addObject("mobile", num.substring(4).trim());
		return mv;
		}
	}*/
	@RequestMapping(value="/orderFoodLocation", method= RequestMethod.GET)
	public ModelAndView orderFoodLocation(HttpSession session){
		String mb= (String) session.getAttribute("userMobile");
		System.out.println("in orderFoodLocation--"+mb);
		ModelAndView mv=new ModelAndView("OrderFoodLocationWise");
		mv.addObject("mobile", mb);
		return mv;
	}
	@RequestMapping(value="/orderFoodRating", method= RequestMethod.GET)
	public ModelAndView orderFoodRating(HttpSession session){
		String mb= (String) session.getAttribute("userMobile");
		System.out.println("in orderFoodRating--"+mb);
		ModelAndView mv=new ModelAndView("OrderFoodRatingWise");
		mv.addObject("mobile", mb);
		return mv;
	}
	
	
	@RequestMapping(value="/restaurantListLocationWise", method= RequestMethod.POST)
	public ModelAndView restaurantListLocationWise(@ModelAttribute("Resturant") Resturant rest, BindingResult result, HttpSession session){
		
		 foodImpl=new FoodDeliveryImpl();

		String mb= (String) session.getAttribute("userMobile");
		System.out.println("in restaurantListLocationWise--"+mb);
		rest=foodImpl.loadRestaurantList(rest);		
		ModelAndView mv=new ModelAndView("OrderFoodLocationWise");
		mv.addObject("resturant", rest.getRestaurantList());
		mv.addObject("mobile", mb);
		return mv;
	}
	
	@RequestMapping(value="/restaurantListRatingWise", method= RequestMethod.POST)
	public ModelAndView restaurantListRatingWise(@ModelAttribute("Resturant") Resturant rest, BindingResult result, HttpSession session){
		
		 foodImpl=new FoodDeliveryImpl();

		String mb= (String) session.getAttribute("userMobile");
		System.out.println("in restaurantListRatingWise--"+mb);
		rest=foodImpl.loadRestaurantListRatingWise(rest);		
		ModelAndView mv=new ModelAndView("OrderFoodRatingWise");
		mv.addObject("resturant", rest.getRestaurantList());
		mv.addObject("mobile", mb);
		return mv;
	}
	@RequestMapping(value="/showRestaurantItem/{id}", method= RequestMethod.GET)
	public ModelAndView showRestaurantItem(@PathVariable("id") String id, @ModelAttribute("Resturant") Resturant rest, BindingResult result, HttpSession session){
		
		 foodImpl=new FoodDeliveryImpl();
		 
		 rest.setTypee(id.substring(3).trim());
		String mb= (String) session.getAttribute("userMobile");
		System.out.println("in showRestaurantItem--"+mb);
		rest=foodImpl.loadRestaurantItems(rest,"");	
		System.out.println("itemssss--"+rest.getFoodItems());
		ModelAndView mv=new ModelAndView("ShowRestaurantItem");
		mv.addObject("foodItems", rest.getFoodItems());
		mv.addObject("resturantType", rest);
		mv.addObject("mobile", mb);
		return mv;
	}
	
	@RequestMapping(value="/orderItems", method= RequestMethod.POST)
	public ModelAndView orderItemListLocationWise(@ModelAttribute("Resturant") Resturant rest, BindingResult result, HttpSession session){
		
		 foodImpl=new FoodDeliveryImpl();

		String mb= (String) session.getAttribute("userMobile");
		rest.setMobileNumber(mb);
		System.out.println("in orderItemListLocationWise--"+mb);
		rest=foodImpl.loadRestaurantItems(rest,"load");		
		ModelAndView mv=new ModelAndView("OrderItemConfirmation");

		mv.addObject("orderFood", rest.getFoodItems());
		mv.addObject("TotalPrice", rest.getTotalPrice());
		mv.addObject("MobileNumber", rest.getMobileNumber());
		return mv;
	}
	@RequestMapping(value="/orderFinalItems", method= RequestMethod.POST)
	public ModelAndView orderItemList(@ModelAttribute("Resturant") Resturant rest, BindingResult result, HttpSession session){
		
		 foodImpl=new FoodDeliveryImpl();
		 ModelAndView mv=new ModelAndView("OrderItemConfirmation");
		mv.addObject("SuccesfullMsg", rest.getName()+" your order placed succesfully");
		return mv;
	}
	
}

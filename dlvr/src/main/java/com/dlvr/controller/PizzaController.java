package com.dlvr.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dlvr.model.entity.Basket;
import com.dlvr.model.entity.Product;
import com.dlvr.model.entity.User;
import com.dlvr.model.repository.BasketRepository;
import com.dlvr.model.repository.ProductRepository;
import com.dlvr.model.repository.UserRepository;


@Controller
@RequestMapping(value = "/pizza")
public class PizzaController {
	
	private final ProductRepository productRepository;
	private final UserRepository userRepository;
	private final BasketRepository basketRepository;

    public PizzaController(ProductRepository productRepository, UserRepository userRepository, BasketRepository basketRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
    }
    
	@RequestMapping(value = "/addtobasket", method = RequestMethod.POST)
	public ModelAndView home(@RequestParam Long id,@RequestParam int number, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("user_id") == null){			
			User user = new User();
			user.setRole("UNKNOWN");
			userRepository.save(user);
			Long user_id = userRepository.findById(user.getId()).get().getId();
			session.setAttribute("user_id", user_id);
		}
		
		Basket basket = new Basket();
		
		String product_name = productRepository.findNameById(id).getName();
		Long user_id = Long.parseLong(session.getAttribute("user_id").toString());
		Double product_price = productRepository.findNameById(id).getPrice();
		String img = productRepository.findNameById(id).getImg();
		basket.setProduct_img(img);
		basket.setProduct_name(product_name);
		basket.setUser_id(user_id);
		basket.setProduct_price(product_price);
		
		if(basketRepository.isExist(user_id, product_name)) {
			basketRepository.increaseCount(user_id, product_name, 
					basketRepository.findByUser_IdAndProduct_name(user_id, product_name).getCount() + number);
		}	
		else {
			basket.setCount(number);
			basketRepository.save(basket);
		}		
		ModelAndView mav = new ModelAndView("redirect:/pizza");
		return mav;
	}
}

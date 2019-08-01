package com.dlvr.controller;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dlvr.model.entity.Basket;
import com.dlvr.model.entity.Order;
import com.dlvr.model.entity.User;
import com.dlvr.model.repository.BasketRepository;
import com.dlvr.model.repository.OrderRepository;
import com.dlvr.model.repository.ProductRepository;
import com.dlvr.model.repository.UserRepository;


@Controller
public class MainController  implements ErrorController{
	
	private final ProductRepository productRepository;
	private final UserRepository userRepository;
	private final BasketRepository basketRepository;
	private final OrderRepository orderRepository;

    public MainController(ProductRepository productRepository, UserRepository userRepository, BasketRepository basketRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
        this.orderRepository = orderRepository;
    }
    
	@GetMapping("/")
	public ModelAndView home() {
		
		ModelAndView mav = new ModelAndView("index");
		/*User user = new User();
		Basket basket = new Basket();
		String product_name = "asd";
		Long user_id = 1l;
		Double product_price = 1.0;
		String img = "asd";
		basket.setProduct_img(img);
		basket.setProduct_name(product_name);
		basket.setUser_id(user_id);
		basket.setProduct_price(product_price);
		basket.setCount(1);
		ArrayList<Basket> baskets = new ArrayList<>();
		baskets.add(basket);
		System.out.println(baskets.get(0));
		System.out.println(user);
		basket.setUser(user);
		user.setBaskets(baskets);
		userRepository.save(user);*/
		return mav;
	}
	@GetMapping("/order_status")
	public ModelAndView showOrderStatus(HttpServletRequest request) {
		
		ModelAndView mav;
		HttpSession session = request.getSession(true);
		if(session.getAttribute("user_id") == null) {
			mav = new ModelAndView("no_orders");
			return mav;
		}
		Long id = Long.parseLong(session.getAttribute("user_id").toString());
		ArrayList<Order> orderlist = orderRepository.findNotDeliveredOrdersById(id);
		mav = new ModelAndView("order_status");		
		mav.addObject("orderlist", orderlist);
		
		return mav;
	}
	@GetMapping(value = "/pizza")
	public ModelAndView showPizza() {
		
		ModelAndView mav = new ModelAndView("pizza");
		
		return mav;
	}
	
	@GetMapping("/drinks")
	public ModelAndView showDrinks() {
		
		ModelAndView mav = new ModelAndView("drinks");
		
		return mav;
	}
	
	@GetMapping("/desserts")
	public ModelAndView showDesserts() {
		
		ModelAndView mav = new ModelAndView("desserts");
		
		return mav;
	}
	@GetMapping("/burgers")
	public ModelAndView showBurgers() {
		
		ModelAndView mav = new ModelAndView("burgers");
		
		return mav;
	}
	@GetMapping("/basket")
	public ModelAndView showMyBucket(HttpServletRequest request) {
		
		ModelAndView mav;
		double basketsprice = 0;
		HttpSession session = request.getSession(true);
		if(session.getAttribute("user_id") == null) {
			mav = new ModelAndView("empty_basket");
			return mav;
		}
		ArrayList<Basket> basketlist = basketRepository.findBasketsById(Long.parseLong(session.getAttribute("user_id").toString()));
		if(basketlist.size() == 0) {
			mav = new ModelAndView("empty_basket");
			return mav;
		}
		for(int i = 0; i < basketlist.size(); i++) {
			basketsprice += (basketlist.get(i).getProduct_price() * basketlist.get(i).getCount());
		}
		mav = new ModelAndView("basket");
		mav.addObject("basketlist", basketlist);
		mav.addObject("basketsprice", basketsprice);
		
		return mav;
	}
	@GetMapping("/account")
	public ModelAndView account(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		ModelAndView mav = new ModelAndView("redirect:/");
		
		if(session.getAttribute("user_login") == null){
			mav = new ModelAndView("redirect:/registration_request");
			return mav;
		}
		String login = session.getAttribute("user_login").toString();
		User user = userRepository.findIdByName(login);
		if(user.getRole().equals("USER")){
			mav = new ModelAndView("redirect:/account/info");
			return mav;
		}
		else if(user.getRole().equals("ADMIN")){
			mav = new ModelAndView("redirect:/account/admin_page");
			return mav;
		}	
		else if(user.getRole().equals("COOK")){
			mav = new ModelAndView("redirect:/account/cook_page");
			return mav;
		}
		else if(user.getRole().equals("COURIER")){
			mav = new ModelAndView("redirect:/account/courier_page");
			return mav;
		}
		return mav;
		
	}
	@GetMapping("/registration_request")
	public ModelAndView registration_request() {
		
		ModelAndView mav = new ModelAndView("registration_request");
		
		return mav;
	}
	@GetMapping("/registration")
	public ModelAndView registration() {
		
		ModelAndView mav = new ModelAndView("registration");
		
		return mav;
	}
	@GetMapping("/registrer")
	public ModelAndView register(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("registration_congratilation");	
		
		return mav;
	}
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mav;
		HttpSession session = request.getSession(true);
		if(session.getAttribute("user_login") != null) {
			mav = new ModelAndView("redirect:/");
			return mav;
		}
		mav = new ModelAndView("login");
		
		return mav;
	}
	@RequestMapping(value="/account/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, @RequestParam String login, @RequestParam String password) {
		ModelAndView mav;
		String hash_password = DigestUtils.md5Hex(password);
		HttpSession session = request.getSession(true);
		if(userRepository.isUserExist(hash_password, login)) {
			if(session.getAttribute("user_id") != null) {
				userRepository.deleteByIdAndRole(Long.parseLong(session.getAttribute("user_id").toString()), "UNKNOWN");
				basketRepository.deleteByUser_Id(Long.parseLong(session.getAttribute("user_id").toString()));
				}
			Long user_id = userRepository.findIdByName(login).getId();
			session.setAttribute("user_id", user_id);
			session.setAttribute("user_login", login);
			User user = userRepository.findIdByName(login);
			if(user.getRole().equals("USER")){
				mav = new ModelAndView("redirect:/account/info");
				return mav;
			}
			else if (user.getRole().equals("ADMIN")) {
				mav = new ModelAndView("redirect:/account/admin_page");
				return mav;
			}
			else if(user.getRole().equals("COOK")){
				mav = new ModelAndView("redirect:/account/cook_page");
				return mav;
			}
			else if(user.getRole().equals("COURIER")){
				mav = new ModelAndView("redirect:/account/courier_page");
				return mav;
			}
		}
		
		mav = new ModelAndView("redirect:/login");
		return mav;
	}
	@RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	     
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	     
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            return "error-500";
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            return "error-500";
	        }
	    }
	    return "error";
    }

	@Override
    public String getErrorPath() {
        return "/error";
    }
	
}

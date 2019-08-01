package com.dlvr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dlvr.model.entity.Order;
import com.dlvr.model.entity.User;
import com.dlvr.model.entity.Wish;
import com.dlvr.model.repository.BasketRepository;
import com.dlvr.model.repository.OrderRepository;
import com.dlvr.model.repository.ProductRepository;
import com.dlvr.model.repository.UserRepository;
import com.dlvr.model.repository.WishRepository;

@Controller
@RequestMapping(value = "/account")
public class AccountController {
	
	private final ProductRepository productRepository;
	private final UserRepository userRepository;
	private final BasketRepository basketRepository;
	private final OrderRepository orderRepository;
	private final WishRepository wishRepository;

    public AccountController(ProductRepository productRepository, UserRepository userRepository, 
    		BasketRepository basketRepository, OrderRepository orderRepository, WishRepository wishRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
        this.orderRepository = orderRepository;
        this.wishRepository = wishRepository;
    }
	    
    
    
    
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public ModelAndView accountInfo(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		ModelAndView mav = new ModelAndView("account");
		String login = session.getAttribute("user_login").toString();
		User user = userRepository.findIdByName(login);
		mav.addObject("user", user);
		return mav;
	}
	@RequestMapping(value = "/info/change", method = RequestMethod.POST)
	public ModelAndView accountInfoChange(HttpServletRequest request) {
		ModelAndView mav;
		HttpSession session = request.getSession(true);
		String login = session.getAttribute("user_login").toString();
		User user = userRepository.findIdByName(login);
		mav = new ModelAndView("account_info_change");
		mav.addObject("user", user);
		return mav;
	}
	@RequestMapping(value = "/info/change/submit", method = RequestMethod.POST)
	public ModelAndView accountInfoChangeSubmit(HttpServletRequest request,@RequestParam String telephone,
			@RequestParam String address, @RequestParam String login) {
		ModelAndView mav;
		HttpSession session = request.getSession(true);
		String user_login = session.getAttribute("user_login").toString();
		Long user_id = Long.parseLong(session.getAttribute("user_id").toString());
		if (login.equals(user_login) || !userRepository.isLoginExist(login)) {
			userRepository.setLogin(user_id, login);
			userRepository.setAddress(user_id, address);
			userRepository.setTelephone(user_id, telephone);
			session.setAttribute("user_login", login);
			mav = new ModelAndView("redirect:/account/info");
			return mav;
		}
		mav = new ModelAndView("user_exist");
		return mav;
	}
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public ModelAndView accountHistory(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		ModelAndView mav = new ModelAndView("history");
		Long id = Long.parseLong(session.getAttribute("user_id").toString());
		ArrayList<Order> orders = orderRepository.findDeliveredOrdersById(id);
		mav.addObject("orders", orders);
		return mav;
	}
	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	public ModelAndView wishPage(HttpServletRequest request) {
		
		
		ModelAndView mav = new ModelAndView("wish");
		return mav;
	}
	@RequestMapping(value = "/wish/make_wish", method = RequestMethod.POST)
	public ModelAndView userMakesWish(HttpServletRequest request,@RequestParam String wish) {
		
		HttpSession session = request.getSession(true);
		ModelAndView mav = new ModelAndView("wish");
		Long id = Long.parseLong(session.getAttribute("user_id").toString());
		Wish wishes = new Wish();
		wishes.setUser_id(id);
		wishes.setWish(wish);
		wishRepository.save(wishes);
		return mav;
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView accountLogout(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		session.setAttribute("user_id", null);
		session.setAttribute("user_login", null);
		ModelAndView mav = new ModelAndView("redirect:/");
		
		return mav;
	}
	@RequestMapping(value = "/admin_page", method = RequestMethod.GET)
	public ModelAndView showAdminPage(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		String login = session.getAttribute("user_login").toString();
		User user = userRepository.findIdByName(login);
		if(user.getRole().equals("ADMIN")) {
			ModelAndView mav = new ModelAndView("admin_page");
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	@RequestMapping(value = "/cook_page", method = RequestMethod.GET)
	public ModelAndView showCookPage(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		ModelAndView mav;
		ArrayList<Order> orderlist = orderRepository.findOrdersWithStatus("cooking");	
		ArrayList<Order> orderedlist = orderRepository.findOrdersWithStatus("ordered");
		String login = session.getAttribute("user_login").toString();
		User user = userRepository.findIdByName(login);
		if(user.getRole().equals("COOK")) {			
			mav = new ModelAndView("cook_page");
			mav.addObject("orderlist", orderlist);
			mav.addObject("orderedlist", orderedlist);
			return mav;
		}
		else {
			mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	@RequestMapping(value = "/cooking_history", method = RequestMethod.GET)
	public ModelAndView showCookingHistory(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		ModelAndView mav;
		Long cook_id = Long.parseLong(session.getAttribute("user_id").toString());
		ArrayList<Order> orderlist = orderRepository.findOrdersByCookId(cook_id );
		String login = session.getAttribute("user_login").toString();
		User user = userRepository.findIdByName(login);
		if(user.getRole().equals("COOK")) {			
			mav = new ModelAndView("cooking_history");
			mav.addObject("orderlist", orderlist);
			return mav;
		}
		else {
			mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	@RequestMapping(value = "/courier_page", method = RequestMethod.GET)
	public ModelAndView showCourierPage(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		ModelAndView mav = new ModelAndView("courier_page");
		ArrayList<Order> orderlist = orderRepository.findOrdersWithStatus("delivering");
		ArrayList<Order> orderedlist = orderRepository.findOrdersWithStatus("cooked");
		String login = session.getAttribute("user_login").toString();
		User user = userRepository.findIdByName(login);
		if(user.getRole().equals("COURIER")) {			
			mav = new ModelAndView("courier_page");
			mav.addObject("orderlist", orderlist);
			mav.addObject("orderedlist", orderedlist);
			return mav;
		}
		else {
			mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	
	@RequestMapping(value = "/delivering_history", method = RequestMethod.GET)
	public ModelAndView showDeliveringHistory(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		ModelAndView mav;
		Long courier_id = Long.parseLong(session.getAttribute("user_id").toString());
		ArrayList<Order> orderlist = orderRepository.findOrdersByCourierId(courier_id);
		String login = session.getAttribute("user_login").toString();
		User user = userRepository.findIdByName(login);
		if(user.getRole().equals("COURIER")) {			
			mav = new ModelAndView("delivering_history");
			mav.addObject("orderlist", orderlist);
			return mav;
		}
		else {
			mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	@RequestMapping(value = "/admin_page/create_cook", method = RequestMethod.GET)
	public ModelAndView createCookPage(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		String login = session.getAttribute("user_login").toString();
		User user = userRepository.findIdByName(login);
		if(user.getRole().equals("ADMIN")) {			
			ModelAndView mav = new ModelAndView("cook_creation");
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	@RequestMapping(value = "/admin_page/create_courier", method = RequestMethod.GET)
	public ModelAndView createCourierPage(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		String login = session.getAttribute("user_login").toString();
		User user = userRepository.findIdByName(login);
		if(user.getRole().equals("ADMIN")) {			
			ModelAndView mav = new ModelAndView("courier_creation");
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	@RequestMapping(value = "/admin_page/assign_cook/assign", method = RequestMethod.POST)
	public ModelAndView assignCook(HttpServletRequest request, @RequestParam Long order_id, @RequestParam Long cook_id) {
		
		HttpSession session = request.getSession(true);
		userRepository.setUserBusyById(cook_id);
		orderRepository.assignCook(cook_id, order_id);				
		String login = session.getAttribute("user_login").toString();
		User user = userRepository.findIdByName(login);
		if(user.getRole().equals("ADMIN")) {			
			ModelAndView mav = new ModelAndView("redirect:/account/admin_page/assign_cook");
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	@RequestMapping(value = "/admin_page/assign_cook", method = RequestMethod.GET)
	public ModelAndView assignCookPage(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);		
		ArrayList<Order> orderlist = orderRepository.findOrdersWithStatus("ordered");
		ArrayList<User> cooklist = userRepository.findFreeWorkers("COOK");		
		String login = session.getAttribute("user_login").toString();
		User user = userRepository.findIdByName(login);
		if(user.getRole().equals("ADMIN")) {			
			ModelAndView mav = new ModelAndView("assign_cook");
			mav.addObject("orderlist", orderlist);
			mav.addObject("cooklist", cooklist);
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	@RequestMapping(value = "/admin_page/assign_courier/assign", method = RequestMethod.POST)
	public ModelAndView assignCourier(HttpServletRequest request, @RequestParam Long order_id, @RequestParam Long courier_id) {
		
		HttpSession session = request.getSession(true);
		userRepository.setUserBusyById(courier_id);
		orderRepository.assignCourier(courier_id, order_id);				
		String login = session.getAttribute("user_login").toString();
		User user = userRepository.findIdByName(login);
		if(user.getRole().equals("ADMIN")) {			
			ModelAndView mav = new ModelAndView("redirect:/account/admin_page/assign_courier");
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	@RequestMapping(value = "/admin_page/assign_courier", method = RequestMethod.GET)
	public ModelAndView assignCourierPage(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		ArrayList<Order> orderlist = orderRepository.findOrdersWithStatus("cooked");
		ArrayList<User> courierlist = userRepository.findFreeWorkers("COURIER");		
		String login = session.getAttribute("user_login").toString();
		User user = userRepository.findIdByName(login);
		if(user.getRole().equals("ADMIN")) {	
			ModelAndView mav = new ModelAndView("assign_courier");
			mav.addObject("orderlist", orderlist);
			mav.addObject("courierlist", courierlist);
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	@RequestMapping(value = "/admin_page/create_cook/create", method = RequestMethod.POST)
	public ModelAndView createCook(HttpServletRequest request,@RequestParam String login, @RequestParam String password, 
															@RequestParam String telephone, @RequestParam String address) {
		HttpSession session = request.getSession(true);
		ModelAndView mav;
		String role = "COOK";
		String hash_password = DigestUtils.md5Hex(password);
		User user = new User();
		if (userRepository.isLoginExist(login) || userRepository.isPasswordExist(hash_password)) {
			mav = new ModelAndView("user_exist");
			return mav;
		}
		user.setLogin(login);
		user.setPassword(hash_password);
		user.setTelephone(telephone);
		user.setAddress(address);
		user.setRole(role);
		userRepository.save(user);
		
		String user_login = session.getAttribute("user_login").toString();
		User user1 = userRepository.findIdByName(user_login);
		if(user1.getRole().equals("ADMIN")) {	
			mav = new ModelAndView("redirect:/account/admin_page/create_cook");
			return mav;
		}
		else {
			mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	
	@RequestMapping(value = "/admin_page/create_courier/create", method = RequestMethod.POST)
	public ModelAndView createCourier(HttpServletRequest request,@RequestParam String login, @RequestParam String password, 
															@RequestParam String telephone, @RequestParam String address) {
		HttpSession session = request.getSession(true);
		ModelAndView mav;
		String role = "COURIER";
		String hash_password = DigestUtils.md5Hex(password);
		User user = new User();
		if (userRepository.isLoginExist(login) || userRepository.isPasswordExist(hash_password)) {
			mav = new ModelAndView("user_exist");
			return mav;
		}
		user.setLogin(login);
		user.setPassword(hash_password);
		user.setTelephone(telephone);
		user.setAddress(address);
		user.setRole(role);
		userRepository.save(user);
		
		String user_login = session.getAttribute("user_login").toString();
		User user1 = userRepository.findIdByName(user_login);
		if(user1.getRole().equals("ADMIN")) {	
			mav = new ModelAndView("redirect:/account/admin_page/create_courier");
			return mav;
		}
		else {
			mav = new ModelAndView("redirect:/");
			return mav;
		}
	}		
	@RequestMapping(value = "/admin_page/show_wishes", method = RequestMethod.GET)
	public ModelAndView showWishes(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		List<Wish> wishes = wishRepository.findAll();		
		String user_login = session.getAttribute("user_login").toString();
		User user1 = userRepository.findIdByName(user_login);
		if(user1.getRole().equals("ADMIN")) {	
			ModelAndView mav = new ModelAndView("wishes");
			mav.addObject("wishes", wishes);
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	
	@RequestMapping(value = "/cook_page/submit_order", method = RequestMethod.POST)
	public ModelAndView cookSubmitsOrder(HttpServletRequest request, @RequestParam Long order_id) {
		
		HttpSession session = request.getSession(true);
		Long id = Long.parseLong(session.getAttribute("user_id").toString());
		orderRepository.setStatus("cooked", order_id);
		userRepository.setUserFreeById(id);
		String user_login = session.getAttribute("user_login").toString();
		User user1 = userRepository.findIdByName(user_login);
		if(user1.getRole().equals("COOK")) {	
			ModelAndView mav = new ModelAndView("redirect:/account/cook_page");
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	@RequestMapping(value = "/courier_page/submit_order", method = RequestMethod.POST)
	public ModelAndView courierSubmitsOrder(HttpServletRequest request, @RequestParam Long order_id) {
		
		HttpSession session = request.getSession(true);
		Long id = Long.parseLong(session.getAttribute("user_id").toString());
		orderRepository.setStatus("delivered", order_id);
		userRepository.setUserFreeById(id);
		String user_login = session.getAttribute("user_login").toString();
		User user1 = userRepository.findIdByName(user_login);
		if(user1.getRole().equals("COURIER")) {	
			ModelAndView mav = new ModelAndView("redirect:/account/courier_page");
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	@RequestMapping(value = "/cook_page/submit_order_cooking", method = RequestMethod.POST)
	public ModelAndView cookSubmitsOrderCooking(HttpServletRequest request, @RequestParam Long order_id) {
		
		HttpSession session = request.getSession(true);
		Long id = Long.parseLong(session.getAttribute("user_id").toString());
		orderRepository.setStatus("cooking", order_id);
		orderRepository.assignCook(id, order_id);
		String user_login = session.getAttribute("user_login").toString();
		User user1 = userRepository.findIdByName(user_login);
		if(user1.getRole().equals("COOK")) {	
			ModelAndView mav = new ModelAndView("redirect:/account/cook_page");
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	@RequestMapping(value = "/courier_page/submit_order_delivering", method = RequestMethod.POST)
	public ModelAndView courierSubmitsOrderDelivering(HttpServletRequest request, @RequestParam Long order_id) {
		
		HttpSession session = request.getSession(true);
		Long id = Long.parseLong(session.getAttribute("user_id").toString());
		orderRepository.setStatus("delivering", order_id);
		orderRepository.assignCourier(id, order_id);
		String user_login = session.getAttribute("user_login").toString();
		User user1 = userRepository.findIdByName(user_login);
		if(user1.getRole().equals("COURIER")) {	
			ModelAndView mav = new ModelAndView("redirect:/account/courier_page");
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	
}

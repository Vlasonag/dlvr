package com.dlvr.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dlvr.model.entity.Basket;
import com.dlvr.model.entity.Order;
import com.dlvr.model.repository.BasketRepository;
import com.dlvr.model.repository.OrderRepository;
import com.dlvr.model.repository.ProductRepository;
import com.dlvr.model.repository.UserRepository;

@Controller
@RequestMapping(value = "/basket")
public class BasketController {
	
	private final ProductRepository productRepository;
	private final UserRepository userRepository;
	private final BasketRepository basketRepository;
	private final OrderRepository orderRepository;

    public BasketController(ProductRepository productRepository, UserRepository userRepository, BasketRepository basketRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
        this.orderRepository = orderRepository;
    }
	@RequestMapping(value="/make_order", method = RequestMethod.POST)
	public ModelAndView makeOrder(HttpServletRequest request) {
		ModelAndView mav;
		HttpSession session = request.getSession(true);
		if(session.getAttribute("user_login") != null) {
			Calendar date = Calendar.getInstance();
			Calendar deliver_date = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");  
			Order order = new Order();
			
			Long user_id = Long.parseLong(session.getAttribute("user_id").toString());
			String user_address = userRepository.findIdByName(session.getAttribute("user_login").toString()).getAddress();
			String user_telephone = userRepository.findIdByName(session.getAttribute("user_login").toString()).getTelephone();
			String description = "";
			
			deliver_date.setTime(new Date());
			deliver_date.add(Calendar.HOUR_OF_DAY, 1);
			ArrayList<Basket> basketlist = basketRepository.findBasketsById(Long.parseLong(session.getAttribute("user_id").toString()));
			Double price = 0.0;
			
			for (Basket basket : basketlist) {
				description += basket.toString() + "\n";
				price += basket.getProduct_price() * basket.getCount();
			}
			description += "Итого: " + price.toString() + " грн";
			order.setDate(formatter.format(date.getTime()).toString());
			order.setUser_id(user_id);
			order.setUser_address(user_address);
			order.setUser_telephone(user_telephone);
			order.setDescription(description);
			order.setDeliver_date(formatter.format(deliver_date.getTime()).toString());
			order.setStatus("ordered");
			orderRepository.save(order);
			basketRepository.deleteByUser_Id(user_id);
			mav = new ModelAndView("order_congratilations");
			return mav;
		}
		mav = new ModelAndView("redirect:/basket/make_order/blank");
		return mav;
	}
	@RequestMapping(value="/make_order/blank", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView goToOrderBlank(HttpServletRequest request) {
		ModelAndView mav;
		Date date = new Date();   // given date
		Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
		calendar.setTime(date);   // assigns calendar to given date
		Integer minhour = calendar.get(Calendar.HOUR_OF_DAY) + 1;
		Integer minminutes = calendar.get(Calendar.MINUTE);
		String str_minminutes = minminutes < 10 ? "0" + minminutes.toString(): minminutes.toString();
		String mintime = minhour + ":" + str_minminutes;
		mav = new ModelAndView("order_blank");
		mav.addObject("mintime", mintime);
		
		return mav;
	}
	@RequestMapping(value="make_order/make_order_with_info", method = RequestMethod.POST)
	public ModelAndView makeOrderBlank(HttpServletRequest request, @RequestParam String telephone, 
			@RequestParam String address, @RequestParam String time) {
		ModelAndView mav;
		String timearr[] = time.split(":");
		int hour = Integer.parseInt(timearr[0]);
		int minute = Integer.parseInt(timearr[1]);
		
		HttpSession session = request.getSession(true);
		Date date1 = new Date();
		Calendar date = Calendar.getInstance();
		Calendar deliver_date = Calendar.getInstance();
		deliver_date.setTime(date1);
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");  
		Order order = new Order();
		deliver_date.set(deliver_date.get(Calendar.YEAR), deliver_date.get(Calendar.MONTH), deliver_date.get(Calendar.DAY_OF_MONTH), hour, minute, 0);
		Long user_id = Long.parseLong(session.getAttribute("user_id").toString());
		String user_address = address;
		String user_telephone = telephone;
		String description = "";
		
		ArrayList<Basket> basketlist = basketRepository.findBasketsById(Long.parseLong(session.getAttribute("user_id").toString()));
		Double price = 0.0;
		
		for (Basket basket : basketlist) {
			description += basket.toString() + "\n";
			price += basket.getProduct_price() * basket.getCount();
		}
		description += "Итого: " + price.toString() + " грн";
		order.setDate(formatter.format(date.getTime()).toString());
		order.setUser_id(user_id);
		order.setUser_address(user_address);
		order.setUser_telephone(user_telephone);
		order.setDescription(description);
		order.setDeliver_date(formatter.format(deliver_date.getTime()).toString());
		order.setStatus("ordered");
		orderRepository.save(order);
		basketRepository.deleteByUser_Id(user_id);
		mav = new ModelAndView("order_congratilations");
		return mav;
	}
	@RequestMapping(value="/clear", method = RequestMethod.POST)
	public ModelAndView clearBasket(HttpServletRequest request) {
		ModelAndView mav;
		HttpSession session = request.getSession(true);
		Long user_id = Long.parseLong(session.getAttribute("user_id").toString());
		basketRepository.deleteByUser_Id(user_id);
		mav = new ModelAndView("redirect:/basket");
		return mav;
		
	}
}

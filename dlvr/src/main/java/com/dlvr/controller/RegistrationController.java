package com.dlvr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dlvr.model.entity.User;
import com.dlvr.model.repository.BasketRepository;
import com.dlvr.model.repository.ProductRepository;
import com.dlvr.model.repository.UserRepository;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {
	
	private final ProductRepository productRepository;
	private final UserRepository userRepository;
	private final BasketRepository basketRepository;

    public RegistrationController(ProductRepository productRepository, UserRepository userRepository, BasketRepository basketRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
    }
    
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam String login, @RequestParam String password, @RequestParam String conf_password,
			@RequestParam String telephone, @RequestParam String address) {
		
		ModelAndView mav;
		String role = "USER";
		String hash_password = DigestUtils.md5Hex(password);
		User user = new User();
		if (userRepository.isLoginExist(login) || userRepository.isPasswordExist(hash_password)) {
			mav = new ModelAndView("user_exist");
			return mav;
		}
		else if(!password.equals(conf_password)) {
			mav = new ModelAndView("user_exist");
			return mav;
		}
		user.setLogin(login);
		user.setPassword(hash_password);
		user.setTelephone(telephone);
		user.setAddress(address);
		user.setRole(role);
		
		
		userRepository.save(user);
		mav = new ModelAndView("registration_congratilation");		
		
		return mav;
	}
	@RequestMapping(value = "/user_exist", method = RequestMethod.POST)
	public ModelAndView showThatUserExist()	{
		ModelAndView mav = new ModelAndView("user_exist");	
		
		return mav;
	}
}

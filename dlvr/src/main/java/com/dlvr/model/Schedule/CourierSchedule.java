package com.dlvr.model.Schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.dlvr.controller.MainController;

@Configuration
@EnableScheduling
public class CourierSchedule {
	//@Scheduled(fixedDelay = 4000)
	public ModelAndView scheduleFixedDelayTask() {
		ModelAndView mav = new ModelAndView("redirect:/");
		System.out.println(123);
		MainController mc = new MainController(null, null, null, null);
		return mav;
	}
}

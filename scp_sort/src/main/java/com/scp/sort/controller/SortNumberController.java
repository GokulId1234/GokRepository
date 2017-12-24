/**
 * 
 */
package com.scp.sort.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.scp.sort.bean.Customer;
import com.scp.sort.bean.SortNumberDataBean;
import com.scp.sort.model.SortNumbers;
import com.scp.sort.service.SortNumberService;
import com.scp.sort.validator.SortNumbersValidator;

/**
 * @author Gokul
 * 
 */

@RestController
@RequestMapping("/api")
public class SortNumberController {
	@Autowired
	SortNumberService sortNumberService;

	@Autowired
	SortNumbersValidator validator;

	/*
	 * @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET) public
	 * String login(){ ModelAndView modelAndView = new ModelAndView();
	 * modelAndView.setViewName("index"); return "index"; }
	 */

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form");
		modelAndView.addObject("sortDataBean", new SortNumberDataBean());
		return modelAndView;
	}

	@GetMapping("/retrieveSortedNumbers")
	public ModelAndView showSortedNumbersHistory() {
		List<SortNumberDataBean> sortNumberDataList = sortNumberService
				.getSortedNumberHistory();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("result");
		modelAndView.addObject("sortedList", sortNumberDataList);
		return modelAndView;
	}

	@RequestMapping(value = "/sortNumbers", method = RequestMethod.POST)
	public ModelAndView sortNumbersInOrder(
			@ModelAttribute SortNumberDataBean sortNumberDataBean,
			BindingResult result, Model model) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form");
		sortNumberDataBean = sortNumberService
				.sortNumbersInOrder(sortNumberDataBean);
		if (sortNumberDataBean.isNotValid()) {
			System.out.println("not valid----");
			sortNumberDataBean.setErrorMsg("Please enter valid inputs");
			modelAndView.addObject("validation", "Error");
		}
		modelAndView.addObject("sortDataBean", sortNumberDataBean);

		// result.
		return modelAndView;
	}
	
	

}

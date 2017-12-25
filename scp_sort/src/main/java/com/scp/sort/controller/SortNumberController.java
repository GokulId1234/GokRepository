/**
 * 
 */
package com.scp.sort.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.scp.sort.bean.SortNumberDataBean;
import com.scp.sort.exception.SortNumberAccessException;
import com.scp.sort.service.SortNumberService;

/**
 * @author Gokul
 *  Rest service class to perform sort number app operations
 */

@RestController
@RequestMapping("/api")
public class SortNumberController {
	@Autowired
	SortNumberService sortNumberService;

	/**
	 * Method to load the application
	 * @return ModelAndView
	 */
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView loadPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form");
		modelAndView.addObject("sortDataBean", new SortNumberDataBean());
		return modelAndView;
	}

	/**
	 * Method to retrieve the history of the sorted elements
	 * @return
	 * @throws SortNumberAccessException
	 */
	@GetMapping("/retrieveSortedNumbers")
	public ModelAndView showSortedNumbersHistory()
			throws SortNumberAccessException {
		List<SortNumberDataBean> sortNumberDataList = sortNumberService
				.getSortedNumberHistory();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("result");
		modelAndView.addObject("sortedList", sortNumberDataList);
		return modelAndView;
	}

	/**
	 * Method to derive numbers in a sorted order
	 * @param sortNumberDataBean
	 * @param model
	 * @return ModelAndView
	 * @throws SortNumberAccessException
	 */
	@RequestMapping(value = "/sortNumbers", method = RequestMethod.POST)
	public ModelAndView sortNumbersInOrder(
			@ModelAttribute("sortAttribute") SortNumberDataBean sortNumberDataBean,
			Model model) throws SortNumberAccessException {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form");
		sortNumberDataBean = sortNumberService
				.sortNumbersInOrder(sortNumberDataBean);
		if (sortNumberDataBean.isNotValid()) {
			sortNumberDataBean.setErrorMsg("Please enter valid inputs");
			modelAndView.addObject("validation", "Error");
		}
		modelAndView.addObject("sortDataBean", sortNumberDataBean);

		return modelAndView;
	}

}

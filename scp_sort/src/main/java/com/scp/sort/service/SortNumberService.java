/**
 * 
 */
package com.scp.sort.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.scp.sort.bean.SortNumberDataBean;
import com.scp.sort.common.RandomQuickSortSeq;
import com.scp.sort.dao.SortNumbersDAO;
import com.scp.sort.helper.SortNumberServiceHelper;
import com.scp.sort.model.SortNumbers;

/**
 * @author Gokul
 * 
 */
@Component
public class SortNumberService {

	@Autowired
	SortNumbersDAO sortNumbersDAO;

	SortNumberServiceHelper sortNumberServiceHelper = new SortNumberServiceHelper();

	/**
	 * 
	 * @param unOrderedNumberList
	 * @return
	 */
	public SortNumberDataBean sortNumbersInOrder(
			SortNumberDataBean sortNumberDataBean) {

		String inputNumbers = sortNumberDataBean.getInputNumbers();
		try {
			Map<String, Object> validateSortNumberMap = sortNumberServiceHelper
					.validateInputNumbers(inputNumbers);

			sortNumberDataBean.setErrorMsg(null);

			boolean isValid = (boolean) validateSortNumberMap.get("isValid");
			if (isValid) {
				int[] intArray = (int[]) validateSortNumberMap.get("intArray");
				Map<String, Object> sortMap = RandomQuickSortSeq
						.getSortedSequence(intArray);
				sortNumberDataBean.setSortedNumbers((String) sortMap
						.get("sequence"));
				sortNumberDataBean.setPositionChanged(sortMap.get("position")
						.toString());
				sortNumberDataBean.setSortedTimeTaken(((Long) sortMap
						.get("time")).toString());

				SortNumbers sortNumbers = new SortNumbers();
				sortNumbers.setSortedNumbers(sortNumberDataBean
						.getSortedNumbers());
				sortNumbers.setPositionChgCnt(Integer
						.parseInt(sortNumberDataBean.getPositionChanged()));
				sortNumbers.setSortedTime(new Long(sortNumberDataBean
						.getSortedTimeTaken()));
				// sortNumbers.setCreatedTimestamp(currentDate);
				// sortNumbers.setUpdatedTimestamp(currentDate);
				SortNumbers saveSortNumbers = saveSortedNumberDetails(sortNumbers);
				System.out.println("saved " + saveSortNumbers.getSerialNo());
			} else {
				sortNumberDataBean.setErrorMsg("Please enter valid inputs");
				sortNumberDataBean.setNotValid(Boolean.TRUE);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sortNumberDataBean;
	}

	/*
	 * public List<SortNumbers> getSortedNumberDetails(); public SortNumbers
	 * saveSortedNumbers(@Valid @RequestBody SortNumbers sortedNumbers);
	 */
	/**
	 * 
	 * @return
	 */
	public List<SortNumberDataBean> getSortedNumberHistory() {
		// Logger.
		System.out.println(" entered inside ");
		List<SortNumberDataBean> sortNumberBeanList = new ArrayList<SortNumberDataBean>();
		List<SortNumbers> sortList = sortNumbersDAO.findAll();
		sortNumberBeanList = sortNumberServiceHelper
				.getSortedListBean(sortList);
		return sortNumberBeanList;

	}

	public SortNumbers saveSortedNumberDetails(
			@Valid @RequestBody SortNumbers sortNumbersDetails) {
		return sortNumbersDAO.save(sortNumbersDetails);
	}

}
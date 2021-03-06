/**
 * 
 */
package com.scp.sort.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.scp.sort.bean.SortNumberDataBean;
import com.scp.sort.common.ConstantsUtil;
import com.scp.sort.common.RandomQuickSortSeq;
import com.scp.sort.dao.SortNumbersDAO;
import com.scp.sort.exception.SortNumberAccessException;
import com.scp.sort.helper.SortNumberServiceHelper;
import com.scp.sort.model.SortNumbers;

/**
 * Service class to perform business logics and handle DAO
 * 
 * @author Gokul
 * 
 */
@Component
public class SortNumberService {

	private static final Logger logger = LoggerFactory
			.getLogger(SortNumberService.class);
	@Autowired
	SortNumbersDAO sortNumbersDAO;
	SortNumberServiceHelper sortNumberServiceHelper = new SortNumberServiceHelper();

	/**
	 * Method to perform numbers in a sorted order and save the sorted number
	 * details in a order
	 * 
	 * @param unOrderedNumberList
	 * @return
	 */
	public SortNumberDataBean sortNumbersInOrder(
			SortNumberDataBean sortNumberDataBean)
			throws SortNumberAccessException {

		String inputNumbers = sortNumberDataBean.getInputNumbers();
		try {
			Map<String, Object> validateSortNumberMap = sortNumberServiceHelper
					.validateInputNumbers(inputNumbers);

			sortNumberDataBean.setErrorMsg(null);

			boolean isValid = (boolean) validateSortNumberMap
					.get(ConstantsUtil.IS_VALID);
			if (isValid) {
				int[] intArray = (int[]) validateSortNumberMap
						.get(ConstantsUtil.INT_ARRAY);
				Map<String, Object> sortMap = RandomQuickSortSeq
						.getSortedSequence(intArray);
				sortNumberDataBean.setSortedNumbers((String) sortMap
						.get(ConstantsUtil.STR_SEQUENCE));
				sortNumberDataBean.setPositionChanged(sortMap.get(
						ConstantsUtil.STR_POSITION).toString());
				sortNumberDataBean.setSortedTimeTaken(((Long) sortMap
						.get(ConstantsUtil.STR_TIME)).toString());

				SortNumbers sortNumbers = new SortNumbers();
				sortNumbers.setSortedNumbers(sortNumberDataBean
						.getSortedNumbers());
				sortNumbers.setPositionChgCnt(Integer
						.parseInt(sortNumberDataBean.getPositionChanged()));
				sortNumbers.setSortedTime(new Long(sortNumberDataBean
						.getSortedTimeTaken()));

				SortNumbers saveSortNumbers = saveSortedNumberDetails(sortNumbers);
				logger.info("saved serialNo" + saveSortNumbers.getSerialNo());
			} else {
				sortNumberDataBean.setErrorMsg(ConstantsUtil.VALID_INPUT);
				sortNumberDataBean.setNotValid(Boolean.TRUE);
			}

		} catch (DataAccessException de) {
			throw new SortNumberAccessException(de.getMessage());
		} catch (Exception exception) {
			throw new SortNumberAccessException(exception.getMessage());
		}
		return sortNumberDataBean;
	}

	/**
	 * Method to get the sorted number details
	 * 
	 * @return List<SortNumberDataBean>
	 */
	public List<SortNumberDataBean> getSortedNumberHistory()
			throws SortNumberAccessException {
		List<SortNumberDataBean> sortNumberBeanList = new ArrayList<SortNumberDataBean>();
		try {

			List<SortNumbers> sortList = sortNumbersDAO.findAll();
			sortNumberBeanList = sortNumberServiceHelper
					.getSortedListBean(sortList);
		} catch (DataAccessException de) {
			throw new SortNumberAccessException(de.getMessage());
		} catch (Exception exception) {
			throw new SortNumberAccessException(exception.getMessage());
		}
		return sortNumberBeanList;

	}

	/**
	 * Method to persist sorted number details
	 * 
	 * @param sortNumbersDetails
	 * @return
	 * @throws SortNumberAccessException
	 */

	private SortNumbers saveSortedNumberDetails(
			@Valid @RequestBody SortNumbers sortNumbersDetails)
			throws SortNumberAccessException {
		try {
			return sortNumbersDAO.save(sortNumbersDetails);
		} catch (DataAccessException de) {
			throw new SortNumberAccessException(de.getMessage());
		} catch (Exception exception) {
			throw new SortNumberAccessException(exception.getMessage());
		}
	}

}

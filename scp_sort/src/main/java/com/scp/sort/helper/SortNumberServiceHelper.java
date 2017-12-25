/**
 * 
 */
package com.scp.sort.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.ValidationUtils;

import com.scp.sort.bean.SortNumberDataBean;
import com.scp.sort.common.ConstantsUtil;
import com.scp.sort.model.SortNumbers;

/**
 * Class to assist SortNumberService
 * @author Gokul
 * 
 */
public class SortNumberServiceHelper {
	
	/**
	 * Method to convert SortNumbers to SortNumberDataBean
	 * @param sortList
	 * @return List<SortNumberDataBean>
	 */

	public List<SortNumberDataBean> getSortedListBean(List<SortNumbers> sortList) {
		
		List<SortNumberDataBean> sortNumberBeanList = new ArrayList<SortNumberDataBean>();
		SortNumberDataBean sortNumberDataBean = null;
		for (SortNumbers sortNumbers : sortList) {
			sortNumberDataBean = new SortNumberDataBean();
			sortNumberDataBean.setSerialNo(sortNumbers.getSerialNo());
			sortNumberDataBean.setSortedNumbers(sortNumbers.getSortedNumbers());
			sortNumberDataBean.setSortedTimeTaken(String.valueOf(sortNumbers
					.getSortedTime()));
			sortNumberDataBean.setPositionChanged(String.valueOf(sortNumbers
					.getPositionChgCnt()));
			sortNumberDataBean.setCreatedTimestamp(sortNumbers
					.getCreatedTimestamp());
			sortNumberBeanList.add(sortNumberDataBean);
		}

		return sortNumberBeanList;

	}
	
	/**
	 * Method to validate input numbers and convert String to input arrays
	 * @param sortNumbers
	 * @return Map<String, Object>
	 */

	public Map<String, Object> validateInputNumbers(String sortNumbers) {

		boolean isValid = true;
		Map<String, Object> validInputMap = new HashMap<String, Object>();
		String[] inputNumberArray = null;
		int[] intArray = null;
		if (null == sortNumbers || sortNumbers.isEmpty()) {
			isValid = false;
		} else {
			inputNumberArray = sortNumbers.split(ConstantsUtil.COMMA_SEPARATOR);

			intArray = new int[inputNumberArray.length];
			try {
				for (int i = 0; i < inputNumberArray.length; i++) {
					intArray[i] = Integer.parseInt(inputNumberArray[i].trim());
				}
			} catch (Exception ne) {
				ne.printStackTrace();
				isValid = false;
			}
		}
		validInputMap.put(ConstantsUtil.INT_ARRAY, intArray);
		validInputMap.put(ConstantsUtil.IS_VALID, isValid);
		return validInputMap;
	}

}

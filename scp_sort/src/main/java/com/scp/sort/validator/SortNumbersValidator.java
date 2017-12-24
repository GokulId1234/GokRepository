/**
 * 
 */
package com.scp.sort.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.scp.sort.bean.SortNumberDataBean;

/**
 * @author Gokul
 * 
 */

@Component
public class SortNumbersValidator implements Validator {

	public boolean supports(Class clazz) {
		return SortNumberDataBean.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		System.out.println("target");
		errors.rejectValue("inputNumbers", "error.inputNumbers",
				"Enter numbers with comma separated");

		SortNumberDataBean sortNumberDataBean = (SortNumberDataBean) target;
		String sortNumbers = sortNumberDataBean.getInputNumbers();
		System.out.println("sortNumbers" + sortNumbers);
		if (null == sortNumbers || sortNumbers.isEmpty()) {

			System.out.println("If loop");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "inputNumbers",
					"error.inputNumbers", "Enter numbers with comma separated");
		} else {
			System.out.println("else loop");
			String[] inputNumberArray = sortNumbers.split(",");

			int[] intArray = new int[inputNumberArray.length];
			try {
				for (int i = 0; i < inputNumberArray.length; i++) {
					System.out.println("checkk---->" + inputNumberArray[i]);
					intArray[i] = Integer.parseInt(inputNumberArray[i]);
				}
			} catch (NumberFormatException ne) {
				System.out.println("exception");
				errors.rejectValue("inputNumbers", "error.inputNumbers",
						"Enter numbers with comma separated");
			}
			// errors.
		}

	}

}
/**
 * 
 */
package com.scp.sort.exception;

/**
 * @author Gokul
 *
 */
public class SortNumberAccessException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public SortNumberAccessException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public SortNumberAccessException() {
		super();
	}
}

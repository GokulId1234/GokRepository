/**
 * 
 */
package com.scp.sort.bean;

import java.util.Date;

/**
 * @author Gokul
 * 
 */
public class SortNumberDataBean {
	private String sortedNumbers;

	private String inputNumbers;

	private String sortedTimeTaken;

	private String positionChanged;

	private long serialNo;

	private Date createdTimestamp;

	private String errorMsg;

	private boolean isNotValid = Boolean.FALSE;

	/**
	 * @return the sortedNumbers
	 */
	public String getSortedNumbers() {
		return sortedNumbers;
	}

	/**
	 * @param sortedNumbers
	 *            the sortedNumbers to set
	 */
	public void setSortedNumbers(String sortedNumbers) {
		this.sortedNumbers = sortedNumbers;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg
	 *            the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * @return the imputNumbers
	 */
	public String getInputNumbers() {
		return inputNumbers;
	}

	/**
	 * @param imputNumbers
	 *            the imputNumbers to set
	 */
	public void setInputNumbers(String imputNumbers) {
		this.inputNumbers = imputNumbers;
	}

	/**
	 * @return the sortedTimeTaken
	 */
	public String getSortedTimeTaken() {
		return sortedTimeTaken;
	}

	/**
	 * @param sortedTimeTaken
	 *            the sortedTimeTaken to set
	 */
	public void setSortedTimeTaken(String sortedTimeTaken) {
		this.sortedTimeTaken = sortedTimeTaken;
	}

	/**
	 * @return the positionChanged
	 */
	public String getPositionChanged() {
		return positionChanged;
	}

	/**
	 * @param positionChanged
	 *            the positionChanged to set
	 */
	public void setPositionChanged(String positionChanged) {
		this.positionChanged = positionChanged;
	}

	/**
	 * @return the serialNo
	 */
	public long getSerialNo() {
		return serialNo;
	}

	/**
	 * @param serialNo
	 *            the serialNo to set
	 */
	public void setSerialNo(long serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * @return the createdTimestamp
	 */
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	/**
	 * @param createdTimestamp
	 *            the createdTimestamp to set
	 */
	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	/**
	 * @return the isNotValid
	 */
	public boolean isNotValid() {
		return isNotValid;
	}

	/**
	 * @param isNotValid
	 *            the isNotValid to set
	 */
	public void setNotValid(boolean isNotValid) {
		this.isNotValid = isNotValid;
	}

}

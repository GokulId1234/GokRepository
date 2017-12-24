/**
 * 
 */
package com.scp.sort.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Gokul Entity bean class for tbl_sort_no
 */

@Entity
@Table(name = "tbl_sort_no")
@EntityListeners(AuditingEntityListener.class)
public class SortNumbers implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "serialno")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long serialNo;

	private String sortedNumbers;

	@Column(name = "changed_pos")
	private int positionChgCnt;

	@Column(name = "sorted_time")
	private long sortedTime;

	@Column(name = "created_timestamp", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdTimestamp;

	@Column(name = "updated_timestamp", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedTimestamp;

	/**
	 * @return the serialNo
	 */
	public Long getSerialNo() {
		return serialNo;
	}

	/**
	 * @param serialNo
	 *            the serialNo to set
	 */
	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}

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
	 * @return the positionChgCnt
	 */
	public int getPositionChgCnt() {
		return positionChgCnt;
	}

	/**
	 * @param positionChgCnt
	 *            the positionChgCnt to set
	 */
	public void setPositionChgCnt(int positionChgCnt) {
		this.positionChgCnt = positionChgCnt;
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
	 * @return the updatedTimestamp
	 */
	public Date getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	/**
	 * @param updatedTimestamp
	 *            the updatedTimestamp to set
	 */
	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	/**
	 * @return the sortedTime
	 */
	public long getSortedTime() {
		return sortedTime;
	}

	/**
	 * @param sortedTime
	 *            the sortedTime to set
	 */
	public void setSortedTime(long sortedTime) {
		this.sortedTime = sortedTime;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
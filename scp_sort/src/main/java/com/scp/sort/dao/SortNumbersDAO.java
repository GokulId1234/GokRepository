/**
 * 
 */
package com.scp.sort.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scp.sort.model.SortNumbers;

/**
 * Class to invoke database through JPA repository
 * @author Gokul 
 */
@Repository
public interface SortNumbersDAO extends JpaRepository<SortNumbers, Long> {

}

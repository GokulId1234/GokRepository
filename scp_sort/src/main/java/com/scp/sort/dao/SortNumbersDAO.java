/**
 * 
 */
package com.scp.sort.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.scp.sort.model.SortNumbers;

/**
 * @author Gokul
 * 
 */
@Repository
public interface SortNumbersDAO extends JpaRepository<SortNumbers, Long> {

}

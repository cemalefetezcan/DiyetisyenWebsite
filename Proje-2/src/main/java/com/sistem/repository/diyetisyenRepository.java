package com.sistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.sistem.model.diyetisyen;

public interface diyetisyenRepository extends JpaRepository<diyetisyen, Long> {
	
	@Query("SELECT d FROM diyetisyen d WHERE d.tckimlik = :tckimlik")
	public diyetisyen getdybytckimlik(@Param("tckimlik") Long tckimlik);
}

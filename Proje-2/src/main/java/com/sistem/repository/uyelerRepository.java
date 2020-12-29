package com.sistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistem.model.uyeler;

public interface uyelerRepository extends JpaRepository<uyeler, Long> {
	
	@Query("SELECT u FROM uyeler u WHERE u.tckimlik = :tckimlik")
	public uyeler getuyebytcno(@Param("tckimlik") Long tckimlik);
	
	@Query("SELECT u FROM uyeler u WHERE u.uid = :uid")
	public uyeler getuyebyid(@Param("uid") Long uid);
}

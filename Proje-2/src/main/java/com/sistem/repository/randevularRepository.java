package com.sistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistem.model.randevular;

public interface randevularRepository extends JpaRepository<randevular, Long> {
	
	@Query("SELECT r FROM randevular r WHERE r.date = :date")
	public randevular getrandevubytarih(@Param("date") String date);
	
	@Query("SELECT r FROM randevular r WHERE r.durum = :durum")
	public randevular getrandevubydurum(@Param("durum") String durum);
	
	@Query("SELECT r FROM randevular r WHERE r.ranid = :ranid")
	public randevular getrandevubyid(@Param("ranid") Long ranid);
	
	@Query("SELECT r FROM randevular r WHERE r.dytid = :dytid AND r.date = :date")
	public randevular getrandevubydytidanddate(@Param("dytid") Long id,@Param("date") String date);
}

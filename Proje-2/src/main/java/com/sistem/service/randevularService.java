package com.sistem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistem.repository.randevularRepository;

@Service
public class randevularService {
	
	@Autowired
	private randevularRepository randevularRepository;
}

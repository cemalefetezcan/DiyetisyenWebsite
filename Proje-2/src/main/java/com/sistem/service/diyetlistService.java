package com.sistem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistem.repository.diyetlistRepository;

@Service
public class diyetlistService {
	
	@Autowired
	private diyetlistRepository diyetlistRepository;
	
}

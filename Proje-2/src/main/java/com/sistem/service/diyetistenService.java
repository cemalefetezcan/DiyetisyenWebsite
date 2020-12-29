package com.sistem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistem.model.diyetisyen;
import com.sistem.model.diyetlist;
import com.sistem.model.randevular;
import com.sistem.model.uyeler;
import com.sistem.repository.diyetisyenRepository;
import com.sistem.repository.diyetlistRepository;
import com.sistem.repository.randevularRepository;
import com.sistem.repository.uyelerRepository;
import com.sistem.yardimcimodel.diyetlistymodel;

@Service
public class diyetistenService {
	
	private diyetisyen diytutucu=new diyetisyen();
	
	@Autowired
	private diyetisyenRepository diyetisyenRepository;
	
	@Autowired
	private diyetlistRepository diyetlistRepository;
	
	@Autowired
	private uyelerRepository uyelerRepository;
	
	@Autowired
	private randevularRepository randevularRepository;
	
	public diyetisyen findDiyetisyen(diyetisyen diyetisyen) {
		diyetisyen diyetisyen2=new diyetisyen();
		try {
			diyetisyen2=diyetisyenRepository.getdybytckimlik(diyetisyen.getTckimlik());
			if(diyetisyen2.getPassword().equals(diyetisyen.getPassword())) {
				diytutucu=diyetisyen2;
			}
			else {
				diytutucu=null;
			}
		} catch (Exception e) {
			System.out.println("Diyetisyen not found");
		}
		//diytutucu=diyetisyen2;
		return diytutucu;
	}
	
	public void adddiyetisyen(diyetisyen diyetisyen) {
		diyetisyenRepository.save(diyetisyen);
		diytutucu=diyetisyen;
	}
	
	public diyetisyen getDiyetisyen() {
		diyetisyen diyetisyen=new diyetisyen();
		diyetisyen=diytutucu;
		return diyetisyen;
	}
	
	public void addDiyetList(diyetlistymodel diyetlistymodel) {
		diyetlist diyetlist=new diyetlist();
		uyeler uyeler=new uyeler();
		
		uyeler=uyelerRepository.getuyebytcno(diyetlistymodel.getHastatckimlik());
		diyetlist.setDytid(diytutucu.getDyid());
		diyetlist.setUyid(uyeler.getUid());
		diyetlist.setInfo(diyetlistymodel.getDiyetlist());
		diyetlistRepository.save(diyetlist);
	}
	
	public List<randevular> listAllrandevu(){
		List<randevular> randevular1=randevularRepository.findAll();
		List<randevular> randevular2=new ArrayList<randevular>();
		int count=randevular1.size();
		int i=0;
		while(i<count) {
			if(randevular1.get(i).getDytid()==diytutucu.getDyid()) {
				randevular2.add(randevular1.get(i));
			}
			i++;
		}
		return randevular2;
	}
	
	public void deleterandevu(Long ranid) {
		randevularRepository.deleteById(ranid);
	}
	
}

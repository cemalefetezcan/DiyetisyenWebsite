package com.sistem.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistem.model.diyetlist;
import com.sistem.model.randevular;
import com.sistem.model.uyeler;
import com.sistem.repository.diyetlistRepository;
import com.sistem.repository.randevularRepository;
import com.sistem.repository.uyelerRepository;
import com.sistem.yardimcimodel.randevuymodel;

@Service
public class uyelerService {
	
	private uyeler uyetutucu=new uyeler();
	
	@Autowired
	private uyelerRepository uyelerRepository;
	
	@Autowired
	private randevularRepository randevularRepository;
	
	@Autowired
	private diyetlistRepository diyetlistRepository;
	
	
	public void addUye(uyeler uye) {
		uyelerRepository.save(uye);
		uyetutucu=uye;
	}
	
	
	
	
	public uyeler findUye(uyeler uye) {
		uyeler uye2=new uyeler();
		try {
			uye2=uyelerRepository.getuyebytcno(uye.getTckimlik());
			if(uye2.getPassword().equals(uye.getPassword())) {
				uyetutucu=uye2;
			}
			else {
				uyetutucu=null;
			}
		} catch (Exception e) {
			System.out.println("User not found");
		}
		//uyetutucu=uye2;
		return uyetutucu;
	}
	
	public uyeler getuye() {
		uyeler uye=new uyeler();
		uye=uyetutucu;
		return uye;
	}
	
	public randevular addRandevu(randevuymodel randevuymodel) {
		randevular randevular=new randevular();
		randevular randevular2=new randevular();
		String islem="";
		if(randevuymodel.getDname().equals("AHMET YERLİ")) {
			randevular.setDytid(2L);
		}
		else {
			randevular.setDytid(1L);
		}
		randevular.setDate(randevuymodel.getDate());
		islem=randevuymodel.getDate();
		randevular.setDate(islem);
		randevular2=randevularRepository.getrandevubydytidanddate(randevular.getDytid(), islem);
		if(randevular2!=null) {
			randevular2=null;
			return randevular2;
		}
		else {
			randevular.setDurum("dolu");
			randevular.setUyid(uyetutucu.getUid());
			randevularRepository.save(randevular);
			return randevular;
		}

		
	}
	
	public List<randevular> listAllrandevu(){
		List<randevular> randevular1=randevularRepository.findAll();
		List<randevular> randevular2=new ArrayList<randevular>();
		int count=randevular1.size();
		int i=0;
		while(i<count) {
			if(randevular1.get(i).getUyid()==uyetutucu.getUid()) {
				randevular2.add(randevular1.get(i));
			}
			i++;
		}
		return randevular2;
	}
	
	public List<diyetlist> listAllDiyetlist(){
		List<diyetlist> diyetlists1=diyetlistRepository.findAll();
		List<diyetlist> diyetlists2=new ArrayList<diyetlist>();
		int count=diyetlists1.size();
		int i=0;
		while(i<count) {
			if(diyetlists1.get(i).getUyid()==uyetutucu.getUid()) {
				diyetlists2.add(diyetlists1.get(i));
			}
			i++;
		}
		return diyetlists2;
				
	}
	
	public void deleterandevu(Long ranid) {
		randevularRepository.deleteById(ranid);
	}
	
}

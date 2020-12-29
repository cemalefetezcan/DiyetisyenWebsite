package com.sistem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.sistem.model.diyetisyen;
import com.sistem.model.diyetlist;
import com.sistem.model.randevular;
import com.sistem.model.uyeler;

import com.sistem.service.diyetistenService;
import com.sistem.service.uyelerService;
import com.sistem.yardimcimodel.diyetlistymodel;
import com.sistem.yardimcimodel.randevuymodel;





@Controller
public class AppController {
	
	@Autowired
	private uyelerService uyelerService;
	
	@Autowired
	private diyetistenService diyetistenService;
	
	@GetMapping("")
	public String HomePage() {
		return "index";
	}
	
	@GetMapping("/hakkimda")
	public String Hakkimizda() {
		return "hakkimda";
	}
	@GetMapping("/login")
	public String giris_kayit(Model model) {
		model.addAttribute("uyeler", new uyeler());
		return "uye_giris_kayit";
	}
	
	@PostMapping("/process_register")
	public String register(uyeler uye) {
		uyelerService.addUye(uye);
		return "index";
	}
	
	@PostMapping("/process_giris")
	public String giris(uyeler uye) {
		String islem="";
		uyeler user2=uyelerService.findUye(uye);
		if(user2!=null) {
			islem="uyeler";
		}else {
			islem="uye_giris_kayit";
		}
		return islem;
	}
	
	@GetMapping("/index2")
	public String UyeHomePage() {
		return "uyeler";
	}
	
	@GetMapping("/hakkimda2")
	public String Hakkimizda2() {
		return "hakkimda2";
	}
	
	@GetMapping("/randevual")
	public String randevual(Model model) {
		model.addAttribute("randevuymodel",new randevuymodel());
		return "randevu_al";
	}
	
	@PostMapping("/process_randevu")
	public String addRandevu(randevuymodel randevuymodel) {
		String islem="";
		randevular randevular=uyelerService.addRandevu(randevuymodel);
		if(randevular!=null) {
			islem="uyeler";
		}
		else {
			islem="randevu_al";
		}
		return islem;
	}
	
	
	@RequestMapping("/uyebilgi")
	public ModelAndView uyebilgi() {
		ModelAndView mav=new ModelAndView("uye_bilgi");
		uyeler uye=uyelerService.getuye();
		mav.addObject("uyeler", uye);
		return mav;
	}
	
	@PostMapping("/edit_uye")
	public String showedituye(uyeler uye) {
		uyelerService.addUye(uye);
		return "uyeler";
	}
	
	
	@GetMapping("/dylogin")
	public String giris_diyetisyen(Model model) {
		model.addAttribute("diyetisyen", new diyetisyen());
		return "diyetisyen_giris";
	}
	
	@PostMapping("/process_dygiris")
	public String giris_dyt(diyetisyen diyetisyen) {
		String islem="";
		diyetisyen diyetisyen2=diyetistenService.findDiyetisyen(diyetisyen);
		if(diyetisyen2!=null) {
			islem="diyetisyenler";
		}else {
			islem="diyetisyen_giris";
		}
		return islem;
	}
	
	@GetMapping("/index3")
	public String DytHomePage() {
		return "diyetisyenler";
	}
	
	@GetMapping("/hakkimda3")
	public String Hakkimizda3() {
		return "hakkimda3";
	}
	
	@RequestMapping("/dyt_bilgi")
	public ModelAndView dytbilgi() {
		ModelAndView mav=new ModelAndView("diyetisyen_bilgileri");
		diyetisyen diyetisyen=diyetistenService.getDiyetisyen();
		mav.addObject("diyetisyen", diyetisyen);
		return mav;
	}
	
	@PostMapping("/edit_dyt")
	public String showeditdyt(diyetisyen diyetisyen) {
		diyetistenService.adddiyetisyen(diyetisyen);
		return "diyetisyenler";
	}
	
	@GetMapping("/dyt_list_add")
	public String showDytList(Model model) {
		model.addAttribute("diyetlistymodel", new diyetlistymodel());
		return "diyetisyen_listesi_ekle";
	}
	
	@PostMapping("/add_dytlist")
	public String addDytList(diyetlistymodel diyetlistymodel) {
		diyetistenService.addDiyetList(diyetlistymodel);
		return "diyetisyenler";
	}
	
	@RequestMapping("/dyt_randevular")
	public String showrandevubydyt(Model model) {
		List<randevular> randevularList=diyetistenService.listAllrandevu();
		model.addAttribute("randevularList", randevularList);
		return "dyt_randevu_kontrol";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleterandevubyDyt(@PathVariable(name = "id") Long ranid) {
		diyetistenService.deleterandevu(ranid);
		return "redirect:/dyt_randevular";
	}
	
	
	@RequestMapping("/uye_randevular")
	public String showrandevubyuye(Model model) {
		List<randevular> randevularList=uyelerService.listAllrandevu();
		model.addAttribute("randevularList", randevularList);
		return "uye_randevu_kontrol";
	}
	
	@RequestMapping("/delete1/{id}")
	public String deleterandevubyuye(@PathVariable(name = "id") Long ranid) {
		uyelerService.deleterandevu(ranid);
		return "redirect:/uye_randevular";
	}
	
	@RequestMapping("/uye_diyetlist")
	public String showdiyetlistbyuye(Model model) {
		List<diyetlist> diyetlists=uyelerService.listAllDiyetlist();
		model.addAttribute("diyetlists", diyetlists);
		return "diyet_listesi";
	}
	
}

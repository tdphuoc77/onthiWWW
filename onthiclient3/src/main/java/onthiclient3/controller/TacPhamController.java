package onthiclient3.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import onthiclient3.config.UploadFile;
import onthiclient3.entity.TacPham;
import onthiclient3.service.ITacGiaService;
import onthiclient3.service.ITacPhamService;
import onthiclient3.validate.TacPhamValidation;

@Controller
public class TacPhamController {
	@Autowired
	private ITacGiaService tacGiaService;
	@Autowired
	private ITacPhamService tacPhamService;
	
	@Autowired
	private UploadFile upload;
	
	@Autowired
	private TacPhamValidation valid;
	
	@GetMapping(value = {"/","/home"})
	public String home(Model model) {
		model.addAttribute("listTP", tacPhamService.getAll());
		return "home";
	}
	@GetMapping("/tacpham/xemchitiet/{maTP}")
	public String xemchitiet(Model model,@PathVariable("maTP") int maTP) {
		TacPham tacPham= tacPhamService.getById(maTP);
		model.addAttribute("tp", tacPham);
		return "xemchitiet";
	}
	
	@GetMapping("/tacpham/add")
	public String addTP(Model model) {
		model.addAttribute("tp", new TacPham());
		model.addAttribute("listTG", tacGiaService.getAll());
		return "addTP";
	}
	
	@PostMapping("/tacpham/add")
	public String saveTP(HttpSession session,Model model,@ModelAttribute("tp") TacPham tp,@RequestParam("h") MultipartFile file, @RequestParam("maTG") int maTG,BindingResult bindingResult  ) throws IOException {
		tp.setHinh(file.getOriginalFilename());
		valid.validate(tp, bindingResult);
		if(bindingResult.hasErrors()) {
			model.addAttribute("listTG", tacGiaService.getAll());
			return "addTP";
		}
		
		upload.upload(file, session);
		
		tp.setTacGia(tacGiaService.getById(maTG));
		tacPhamService.add(tp);
		return "redirect:/home";
	}
	
	@GetMapping("/tacpham/quanly")
	public String quanLy(Model model) {
		model.addAttribute("listTP", tacPhamService.getAll());
		return "quanly";
	}
	
	@GetMapping("/tacpham/update/{maTP}")
	public String update(Model model,@PathVariable("maTP") int maTP) {
		model.addAttribute("tp", tacPhamService.getById(maTP));
		model.addAttribute("listTG", tacGiaService.getAll());
		return "addTP";
	}
	
	@PostMapping("/tacpham/update/{maTP}")
	public String saveUpdate(HttpSession session,Model model,@ModelAttribute("tp") TacPham tp,@RequestParam("h") MultipartFile file, @RequestParam("maTG") int maTG,BindingResult bindingResult ) throws IOException {
		tp.setHinh(file.getOriginalFilename());
		valid.validate(tp, bindingResult);
		if(bindingResult.hasErrors()) {
			model.addAttribute("listTG", tacGiaService.getAll());
			return "addTP";
		}
		upload.upload(file, session);
		tp.setTacGia(tacGiaService.getById(maTG));
		tacPhamService.updateTG(tp);
		return "redirect:/tacpham/quanly";
	}
	
	@GetMapping("/tacpham/delete/{maTP}")
	public String delete(@PathVariable("maTP") int maTP) {
		tacPhamService.delete(maTP);
		return "redirect:/tacpham/quanly";
	}
	@GetMapping("/tacpham/quanly/timkiem")
	public String timKiem(Model model,@RequestParam("key") String key) {
		model.addAttribute("listTP", tacPhamService.getByTen(key));
		return "quanly";
	}
	@GetMapping("/tacpham/quanly/gia/tang")
	public String giaTang(Model model) {
		model.addAttribute("listTP", tacPhamService.getByGiaTang());
		return "quanly";
	}
	@GetMapping("/tacpham/quanly/gia/giam")
	public String giaGiam(Model model) {
		model.addAttribute("listTP", tacPhamService.getByGiaGiam());
		return "quanly";
	}
	
}

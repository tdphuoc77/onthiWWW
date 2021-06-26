package onthiclient3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import onthiclient3.entity.TacGia;
import onthiclient3.service.ITacGiaService;
import onthiclient3.service.ITacPhamService;
import onthiclient3.validate.TacGiaValidation;

@Controller
public class TacGiaController {
	@Autowired
	private ITacGiaService tacGiaService;
	@Autowired
	private ITacPhamService tacPhamService;
	
	@Autowired
	private TacGiaValidation valid;
	
	@GetMapping("/tacgia")
	public String dsTG(Model model) {
		model.addAttribute("listTG", tacGiaService.getAll());
		return "listTG";
	}
	
	@GetMapping("/tacgia/add")
	public String add(Model model) {
		model.addAttribute("tg", new TacGia());
		return "addTG";
	}
	
	@PostMapping("/tacgia/add")
	public String save(@ModelAttribute("tg") TacGia tg,Model model,BindingResult bindingResult) {
		valid.validate(tg, bindingResult);
		if(bindingResult.hasErrors()) {
			return "addTG";
		}
		tacGiaService.addTacGia(tg);
		return "redirect:/tacgia";
	}
	@GetMapping("/tacgia/update/{maTG}")
	public String add(Model model,@PathVariable("maTG") int maTG) {
		model.addAttribute("tg", tacGiaService.getById(maTG));
		return "addTG";
	}
	@PostMapping("/tacgia/update/{maTG}")
	public String add(@ModelAttribute("tg") TacGia tg,BindingResult bindingResult,Model model) {
		valid.validate(tg, bindingResult);
		if(bindingResult.hasErrors()) {
			return "addTG";
		}
		tacGiaService.update(tg);;
		return "redirect:/tacgia";
	}
	
//	tacgia/1	
	@GetMapping("/tacpham/tacgia/{maTG}")
	public String xemTP(Model model,@PathVariable("maTG") int maTG) {
		model.addAttribute("listTP", tacPhamService.getByTacGia(maTG));
		return "quanly";
	}
}

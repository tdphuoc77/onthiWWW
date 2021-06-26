package onthiserver3.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import onthiserver3.dao.TacPhamDao;
import onthiserver3.entity.TacPham;

@RestController
@RequestMapping("/tacpham")
public class TacPhamRestController {
	@Autowired
	private TacPhamDao dao;
	
//	@Autowired
//	private TacPhamRepository tacPhamRepository;
//	
//	@GetMapping
//	public List<TacPham> getAll() {
//		return tacPhamRepository.findAll();
//	}
//	@GetMapping("/tacgia/{maTG}")
//	public List<TacPham> getByTacGia(@PathVariable int maTG) {
//		return tacPhamRepository.findByTacGiaMaTG(maTG);
//	}
//	@GetMapping("/{id}")
//	public TacPham getById(@PathVariable int id) {
//		return tacPhamRepository.findById(id).get();
//	}
//	@PostMapping()
//	public TacPham postTP(@RequestBody TacPham tacPham) {
//		tacPhamRepository.save(tacPham);
//		return tacPham;
//	}
//	@PutMapping()
//	public TacPham putTP(@RequestBody TacPham tacPham) {
//		tacPhamRepository.save(tacPham);
//		return tacPham;
//	}
//	@DeleteMapping("/{id}")
//	public void deleteTP(@PathVariable int id) {
//		tacPhamRepository.deleteById(id);
//	}
	
	@GetMapping
	public List<TacPham> getAll() {
		return dao.getAll();
	}
	@GetMapping("/tacgia/{maTG}")
	public List<TacPham> getByTacGia(@PathVariable int maTG) {
		return dao.getByTacGia(maTG);
	}
	
	@GetMapping("/ten")
	public List<TacPham> getByTen(@RequestParam String tenTP) {
		return dao.getByTenTP(tenTP);
	}
	
	@GetMapping("/gia/tang")
	public List<TacPham> sapXepTang() {
		return dao.sapXepGiaTang();
	}
	@GetMapping("/gia/giam")
	public List<TacPham> sapXemGiam() {
		return dao.sapXepGiaGiam();
	}
	@GetMapping("/{id}")
	public TacPham getById(@PathVariable int id) {
		return dao.getById(id);
	}
	@PostMapping()
	public TacPham postTP(@RequestBody TacPham tacPham) {
		dao.addTacPham(tacPham);
		return tacPham;
	}
	@PutMapping()
	public TacPham putTP(@RequestBody TacPham tacPham) {
		dao.updateTacPham(tacPham);
		return tacPham;
	}
	@DeleteMapping("/{id}")
	public void deleteTP(@PathVariable int id) {
		dao.deleteTacPham(id);
	}
	
}

package onthiclient3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import onthiclient3.entity.TacPham;
import onthiclient3.service.ITacPhamService;

@Service
public class TacPhamService implements ITacPhamService {

	@Autowired
	private RestTemplate restTemplate;

	public List<TacPham> getAll() {
		return restTemplate.exchange("tacpham", HttpMethod.GET, null, new ParameterizedTypeReference<List<TacPham>>() {
		}).getBody();
	}

	public TacPham getById(int id) {
		return restTemplate.getForObject("tacpham/"+id, TacPham.class);
	}

	public List<TacPham> getByTacGia(int maTG) {
		return restTemplate.exchange("tacpham/tacgia/"+maTG, HttpMethod.GET, null, new ParameterizedTypeReference<List<TacPham>>() {
		}).getBody();
	}

	public void add(TacPham tacPham) {
		restTemplate.postForEntity("tacpham", tacPham, TacPham.class);
	}

	public void updateTG(TacPham tacPham) {
		restTemplate.put("tacpham", tacPham);
	}

	public void delete(int id) {
		restTemplate.delete("tacpham/"+id);
	}

	public List<TacPham> getByTen(String key) {
		return restTemplate.exchange("tacpham/ten?tenTP="+key, HttpMethod.GET, null, new ParameterizedTypeReference<List<TacPham>>() {
		}).getBody();
	}

	public List<TacPham> getByGiaTang() {
		return restTemplate.exchange("tacpham/gia/tang", HttpMethod.GET, null, new ParameterizedTypeReference<List<TacPham>>() {
		}).getBody();
	}

	public List<TacPham> getByGiaGiam() {
		return restTemplate.exchange("tacpham/gia/giam", HttpMethod.GET, null, new ParameterizedTypeReference<List<TacPham>>() {
		}).getBody();
	}
}

package onthiclient3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import onthiclient3.entity.TacGia;
import onthiclient3.service.ITacGiaService;
@Service
public class TacGiaService implements ITacGiaService {
	
	@Autowired
	private RestTemplate restTemplate;

	public List<TacGia> getAll() {
		// TODO Auto-generated method stub
		return restTemplate.exchange("tacgia", HttpMethod.GET, null, new ParameterizedTypeReference<List<TacGia>>() {
		}).getBody();
	}

	public TacGia getById(int maTG) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("tacgia/"+maTG, TacGia.class);
	}

	public void addTacGia(TacGia tacGia) {
		restTemplate.postForEntity("tacgia", tacGia, TacGia.class);
	}

	public void update(TacGia tacGia) {
		restTemplate.put("tacgia", tacGia);
	}
}

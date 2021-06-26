package onthiclient3.service;

import java.util.List;

import onthiclient3.entity.TacGia;

public interface ITacGiaService {
	List<TacGia> getAll();
	TacGia getById(int maTG);
	void addTacGia(TacGia tacGia);
	void update(TacGia tacGia);
}

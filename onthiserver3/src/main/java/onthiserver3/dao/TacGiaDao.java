package onthiserver3.dao;

import java.util.List;

import onthiserver3.entity.TacGia;

public interface TacGiaDao {
	List<TacGia> getAll();
	TacGia getById(int id);
	void addTacGia(TacGia tacGia);
	void updateTacGia(TacGia tacGia);
}

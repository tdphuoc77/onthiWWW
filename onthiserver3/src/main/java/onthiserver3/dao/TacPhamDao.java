package onthiserver3.dao;

import java.util.List;

import onthiserver3.entity.TacPham;

public interface TacPhamDao {
	List<TacPham> getAll();
	TacPham getById(int maTP);
	void addTacPham(TacPham tacPham);
	void updateTacPham(TacPham tacPham);
	void deleteTacPham(int id);
	List<TacPham> getByTacGia(int maTG);
	List<TacPham> getByTenTP(String tenTP);
	List<TacPham> sapXepGiaTang();
	List<TacPham> sapXepGiaGiam();
}

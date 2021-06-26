package onthiserver3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import onthiserver3.entity.TacPham;

public interface TacPhamRepository extends JpaRepository<TacPham, Integer> {
	
	List<TacPham> findByTacGiaMaTG(int maTG);

}

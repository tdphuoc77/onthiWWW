package onthiserver3.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import onthiserver3.dao.TacPhamDao;
import onthiserver3.entity.TacPham;

@Repository
@Transactional
public class TacPhamDaoImpl  implements TacPhamDao{

	@Autowired
	private SessionFactory sessionFactory;

	public List<TacPham> getAll() {
		Session session=sessionFactory.getCurrentSession();
		
		return session.createNativeQuery("select * from tacpham", TacPham.class).getResultList();
	}

	public TacPham getById(int maTP) {
		Session session=sessionFactory.getCurrentSession();
		return session.find(TacPham.class, maTP);
	}

	public void addTacPham(TacPham tacPham) {
		Session session=sessionFactory.getCurrentSession();
		session.save(tacPham);
		
	}

	public void updateTacPham(TacPham tacPham) {
		Session session=sessionFactory.getCurrentSession();
		session.update(tacPham);
	}

	public void deleteTacPham(int id) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(session.find(TacPham.class, id));
	}

	public List<TacPham> getByTacGia(int maTG) {
		Session session=sessionFactory.getCurrentSession();
		return session.createNativeQuery("select * from tacpham where tacgiaID = "+maTG, TacPham.class).getResultList();
	}

	public List<TacPham> getByTenTP(String tenTP) {
		Session session=sessionFactory.getCurrentSession();
		return session.createNativeQuery("select * from tacpham where tenTP like '%"+tenTP+"%'", TacPham.class).getResultList();

	}

	public List<TacPham> sapXepGiaTang() {
		Session session=sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT * FROM TacPham ORDER BY gia ASC", TacPham.class).getResultList();

	}

	public List<TacPham> sapXepGiaGiam() {
		Session session=sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT * FROM TacPham ORDER BY gia DESC", TacPham.class).getResultList();

	}
	
	
}

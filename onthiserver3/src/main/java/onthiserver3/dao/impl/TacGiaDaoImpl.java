package onthiserver3.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import onthiserver3.dao.TacGiaDao;
import onthiserver3.entity.TacGia;

@Repository
@Transactional
@Service
public class TacGiaDaoImpl implements TacGiaDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<TacGia> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT * FROM TACGIA", TacGia.class).getResultList();
	}

	public TacGia getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return session.find(TacGia.class, id);
	}

	public void addTacGia(TacGia tacGia) {
		Session session=sessionFactory.getCurrentSession();
		session.save(tacGia);
	}

	public void updateTacGia(TacGia tacGia) {
		Session session=sessionFactory.getCurrentSession();
		session.update(tacGia);
	}
	
	
}

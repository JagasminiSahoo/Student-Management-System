package com.org.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.AdminDao;
import com.org.dto.Admin;
import com.org.utilities.Helper;
@Component
public class AdminDaoImpl implements AdminDao{

	@Override
	public void saveAndUpdate(Admin admin) {
		EntityManagerFactory emf = Helper.getEFactory();
	    EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(admin);
		et.commit();
	}

	@Override
	public Admin fetchAdminById(int id) {
		EntityManagerFactory emf = Helper.getEFactory();
		EntityManager em = emf.createEntityManager();
		Admin admin = em.find(Admin.class, id);
		return admin;
	}

	@Override
	public List<Admin> verifyAdminByEmailAndPwd(String email, String password) {
		EntityManagerFactory emf = Helper.getEFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT a FROM Admin a WHERE a.email=?1 AND a.password=?2 ";
		
		Query query = em.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<Admin> list = query.getResultList();
		return list; 
//		if(list.isEmpty())
//			return false;
//		return true;	

		
		
		
		
		
	}
	


}

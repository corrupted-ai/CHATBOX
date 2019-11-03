package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.model.Post;

public class PostDaoImpl implements PostDao{
	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("myPersistence");
	@Override
	public void create(Post p) {
		EntityManager em= emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	

}

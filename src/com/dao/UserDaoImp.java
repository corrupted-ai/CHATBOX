package com.dao;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.model.Group;
import com.model.Post;
import com.model.User;

public class UserDaoImp implements UserDao{
	
	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("myPersistence");
	
	
	@Override
	public void create(User user) {
		EntityManager em= emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
	}

	@Override
	public List<User> findAll() {
		EntityManager em=emf.createEntityManager();
		List<User> users=em.createQuery("SELECT u FROM User u", User.class).getResultList();
		return users;
	}

	@Override
	public User find(String id) {
		EntityManager em=emf.createEntityManager();
		User u=em.find(User.class, id);
		return u;
	}

	@Override
	public List<Group> findAllGroups(User u) {
		String id=u.getId();
		User uu=this.find(id);
		List<Group> groups = uu.getGroups();
		return groups;
	}

	@Override
	public List<Post> findAllPosts(User u) {
		String id=u.getId();
		User uu=this.find(id);
		List<Post> posts = uu.getPosts();
		return posts;
	}

	@Override
	public boolean validate(String email, String password) {
		List<User> users=this.findAll();
		for(User u:users) {
			if(u.getEmail().equalsIgnoreCase(email)){
				if(u.getPassword().equals(password)) {return true;}
			}
		}
		return false;
	}

	@Override
	public User findByName(String name) {
		EntityManager em=emf.createEntityManager();
		User u=em.createQuery("SELECT u FROM User u WHERE u.name= :name", User.class).setParameter("name", name).getResultList().get(0);
		return u;
	}
	@Override
	public User findByemail(String email) {
		EntityManager em=emf.createEntityManager();
		User u=em.createQuery("SELECT u FROM User u WHERE u.email= :email", User.class).setParameter("email", email).getResultList().get(0);
		return u;
	}
	
	public boolean emailpresent(String email) {
		EntityManager em=emf.createEntityManager();
		
		try{User u=em.createQuery("SELECT u FROM User u WHERE u.email= :email", User.class).setParameter("email", email).getSingleResult();
		if(u.getEmail()!= null) {
			return true;}}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	@Override
	public void addPostToUser(User u, Post p) {
		EntityManager em2=emf.createEntityManager();
		u.setPosts(p);
		em2.getTransaction().begin();
		em2.merge(u);
		em2.getTransaction().commit();
	}

	@Override
	public void addGroupToUser(User u, Group g) {
		EntityManager em=emf.createEntityManager();
		u.setGroups(g);
		g.setUsers(u);
		em.getTransaction().begin();
		em.merge(u);
		em.merge(g);
		em.getTransaction().commit();
	}
	public void removeGroupUser(User u, Group g) {
		EntityManager em=emf.createEntityManager();
		u.removeGroups(g);
		g.removeUsers(u);
		em.getTransaction().begin();
		em.merge(u);
		em.merge(g);
		em.getTransaction().commit();
	}
	public List<User> searchuser(String name){
		List<User> users=this.findAll();
		List<User> found = new LinkedList<User>();
		for(User u : users) {
			if(u.getName().indexOf(name)!=-1) {
				found.add(u);
			}
		}
		return found;
	}

}

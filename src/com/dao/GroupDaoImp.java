package com.dao;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.model.Group;
import com.model.Post;
import com.model.User;

public class GroupDaoImp implements GroupDao{
	
	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("myPersistence");
	
	@Override
	public void create(Group group ,User u) {
		UserDaoImp udao= new UserDaoImp();
		u.setGroups(group);
		group.setUsers(u);
		EntityManager em= emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(group);
		em.merge(u);
		em.merge(group);
		em.getTransaction().commit();
	}

	@Override
	public List<User> findUsersInGroup(Group group) {
		String gid=group.getGid();
		Group gg=this.find(gid);
		List<User> users = gg.getUsers();
		return users;
	}

	@Override
	public Group find(String id) {
		EntityManager em = emf.createEntityManager();
		Group g=em.find(Group.class, id);
		return g;
	}

	@Override
	public List<Post> findAllPostsInGroup(Group g) {
//		List<User> users = this.findUsersInGroup(g);
//		List<Post> posts=new LinkedList<Post>();
//		for(User u : users) {
//			List<Post> pfind = new LinkedList(u.getPosts());
//			for(Post p : pfind) {
//			if(p.getGroup().getId().equals(g.getGid())) {posts.add(p);}
//			}
//		}
//		return posts;
		
		String gid=g.getGid();
		EntityManager em=emf.createEntityManager();
		List<Post> posts=em.createQuery("SELECT p FROM Post p WHERE p.groupId=:groupid", Post.class).setParameter("groupid", gid).getResultList();
		return posts;
	}

}

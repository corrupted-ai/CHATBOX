package com.dao;

import java.util.List;

import com.model.Group;
import com.model.Post;
import com.model.User;


public interface UserDao {
	public void create(User user);
	public List<User> findAll();
	public User find(String id);
	public List<Group> findAllGroups(User u);
	public List<Post> findAllPosts(User u);
	public boolean validate(String email,String password);
	public User findByName(String name);
	public void addPostToUser(User u,Post p);
	public void addGroupToUser(User u,Group g);
	User findByemail(String email);
	public boolean emailpresent(String email);
	public List<User> searchuser(String name);
	public void removeGroupUser(User u, Group g);
}

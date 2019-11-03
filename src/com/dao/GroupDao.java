package com.dao;

import java.util.List;

import com.model.Group;
import com.model.Post;
import com.model.User;

public interface GroupDao {
	public List<User> findUsersInGroup(Group group);
	public Group find(String id);
	public List<Post> findAllPostsInGroup(Group g);
	void create(Group group, User u);
}

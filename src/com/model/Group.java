package com.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "groups")
public class Group {

	@Id
	@GeneratedValue(generator = "id_gen")
	@GenericGenerator(name = "id_gen",strategy = "uuid2")
	private String gid;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<User> users =new LinkedList<>();
	
	private String groupName;
	

	private String adminid;
	
	public String getGid() {
		return gid;
	}
	
	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public List<User> getUsers() {
		return users;
	}
	public void setUsers(User user) {
		this.users.add(user);
	}
	public void removeUsers(User user) {
		int i=0;
		for(User us :this.users) {
			if(us.getId().equals(user.getId())) {
				break;
			}
			i++;
		}
		this.users.remove(i);
	}
	public String getGroupName() {
		return groupName;
	}
	public Group() {
		
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Group(String groupName,User user) {
		super();
		this.adminid=user.getId();
		this.users.add(user);
		this.groupName = groupName;
	}
	
	
}

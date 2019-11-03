package com.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(generator = "id_gen")
	@GenericGenerator(name = "id_gen",strategy = "uuid2")
	private String id;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Post> posts=new LinkedList<>();
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Group> groups = new LinkedList<>();
	
	private String name;
	private String email;
	public User() {
	}
	private long phone;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(Post p) {
		this.posts.add(p);
	}
	public List<Group> getGroups() {
		return groups;
	}
	public User(String name, String email, long phone, String password) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	public void setGroups(Group g) {
		this.groups.add(g);
	}
	public void removeGroups(Group g) {
		int i=0;
		for(Group gd :this.groups) {
			if(gd.getGid().equals(g.getGid())) {
				break;
			}
			i++;
		}
		this.groups.remove(i);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

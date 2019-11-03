package com.services;

import com.model.User;

public class UserinGroup {
	private User user;
	private boolean ingroup;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isIngroup() {
		return ingroup;
	}
	public void setIngroup(boolean ingroup) {
		this.ingroup = ingroup;
	}
	public UserinGroup(User u) {
		this.user=u;
		this.ingroup=false;
	} 
	
}

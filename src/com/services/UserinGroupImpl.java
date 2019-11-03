package com.services;

import java.util.LinkedList;
import java.util.List;

import com.dao.GroupDaoImp;
import com.model.Group;
import com.model.User;

public class UserinGroupImpl {
	public static List<UserinGroup> usersinagroup(Group g, List<User> allusers) {
		List<UserinGroup> uiglist = new LinkedList<UserinGroup>();
		for(User u: allusers) {
			UserinGroup uig= new  UserinGroup(u);
			for(Group g1 :u.getGroups()) {
				if(g.getGid().equals(g1.getGid())) {uig.setIngroup(true);}
			}
			uiglist.add(uig);
		}
		return uiglist;
	}

	public static List<UserinGroup> usersinagroup(List<User> allusers) {
		List<UserinGroup> usersingroup = new LinkedList<>();
		for (User u : allusers) {
			UserinGroup ug = new UserinGroup(u);
			usersingroup.add(ug);
		}
		return usersingroup;
	}
}

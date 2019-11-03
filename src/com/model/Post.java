package com.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "posts")
public class Post implements Comparable<Post> {
	@Id
	@GeneratedValue(generator = "id_gen")
	@GenericGenerator(name = "id_gen", strategy = "uuid2")
	private String id;
	@OneToOne(cascade = CascadeType.MERGE)
	private Group group;
	@OneToOne(cascade = CascadeType.MERGE)
	private User postedby;

	public Post() {

	}

	private String post;
	private String groupId;
	private String datetime;

	public String getGroupId() {
		return this.group.getGid();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public User getPostedby() {
		return postedby;
	}

	public void setPostedby(User postedby) {
		this.postedby = postedby;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Post(Group group, User postedBy, String post) {
		this.groupId = group.getGid();
		this.group = group;
		this.postedby = postedBy;
		this.post = post;
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		this.datetime = myDateObj.format(myFormatObj);

	}

	public String getDatetime() {
		return datetime;
	}


	public int compareTo(Post o) {
		String d1 = this.datetime;
		String d2 = o.datetime;
		int iday = Integer.parseInt(d1.substring(0, 2));
		int imonth = Integer.parseInt(d1.substring(3, 5));
		int iyear = Integer.parseInt(d1.substring(6, 10));
		int ihour = Integer.parseInt(d1.substring(11, 13));
		int imin = Integer.parseInt(d1.substring(14, 16));
		int isec = Integer.parseInt(d1.substring(17, 19));

		int fday = Integer.parseInt(d2.substring(0, 2));
		int fmonth = Integer.parseInt(d2.substring(3, 5));
		int fyear = Integer.parseInt(d2.substring(6, 10));
		int fhour = Integer.parseInt(d2.substring(11, 13));
		int fmin = Integer.parseInt(d2.substring(14, 16));
		int fsec = Integer.parseInt(d2.substring(17, 19));

		if (iyear - fyear > 0) {
			return 1;
		} else if (iyear - fyear < 0) {
			return -1;
		} else {
			if (imonth - fmonth > 0) {
				return 1;
			} else if (imonth - fmonth < 0) {
				return -1;
			} else {
				if (iday - fday > 0) {
					return 1;
				} else if (iday - fday < 0) {
					return -1;
				} else {
					if (ihour - fhour > 0) {
						return 1;
					} else if (ihour - fhour < 0) {
						return -1;
					} else {
						if (imin - fmin > 0) {
							return 1;
						} else if (imin - fmin < 0) {
							return -1;
						} else {
							if (isec - fsec > 0) {
								return 1;
							} else if (isec - fsec < 0) {
								return -1;
							} else {
								return 1;
							}

						}
					}
				}
			}
			
		}

	}
	
}

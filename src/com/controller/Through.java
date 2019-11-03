package com.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.GroupDaoImp;
import com.dao.UserDaoImp;
import com.model.Group;
import com.model.User;
import com.services.UserinGroup;

/**
 * Servlet implementation class Through
 */
@WebServlet("/through")
public class Through extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Through() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		GroupDaoImp gdao=new GroupDaoImp();
		UserDaoImp udao = new UserDaoImp();
		Group g=(Group) session.getAttribute("presentgroup");
		User current = (User) session.getAttribute("user");
		List<User> groupusers= new LinkedList<>(gdao.findUsersInGroup(g));
		List<User> allusers=udao.findAll();
		if(g.getAdminid().equals(current.getId())) {session.setAttribute("isadmin", true);}
		else {session.setAttribute("isadmin", false);}
		boolean isadmin=(boolean) session.getAttribute("isadmin");
		if(isadmin) {
			List<UserinGroup> uiglist = new LinkedList<UserinGroup>();
			for(User u: allusers) {
				UserinGroup uig= new  UserinGroup(u);
				for(User u1 :groupusers) {
					if(u.getId().equals(u1.getId())) {uig.setIngroup(true);}
				}
				uiglist.add(uig);
			}
			
			session.setAttribute("fullusers", uiglist);
		}
		session.setAttribute("middleblock","common/ingroup.jsp");
		request.getRequestDispatcher("viewposts").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

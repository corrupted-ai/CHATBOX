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

import com.dao.UserDaoImp;
import com.model.Group;
import com.model.User;

/**
 * Servlet implementation class Mygroups
 */
@WebServlet("/mygroups")
public class Mygroups extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mygroups() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		User u=(User) session.getAttribute("user");
		UserDaoImp udao=new UserDaoImp();
		try {
		List<Group> groups =new LinkedList<>(udao.findAllGroups(u));
		request.setAttribute("nogroups", false);
		request.setAttribute("yourgroups", groups);
		if(groups.size()==0) {request.setAttribute("nogroups", true);}
		}
		catch (Exception e) {
			request.setAttribute("nogroups", true);
		}
		session.setAttribute("isadmin", false);
		session.setAttribute("middleblock", "common/groupview.jsp");
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

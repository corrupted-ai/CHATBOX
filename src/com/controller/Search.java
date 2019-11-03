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
import com.services.UserinGroup;
import com.services.UserinGroupImpl;

/**
 * Servlet implementation class Search
 */
@WebServlet("/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String sname=request.getParameter("sname");
		boolean isadmin = (boolean) session.getAttribute("isadmin");
		UserDaoImp udao=new UserDaoImp();
		List<User> foundusers=new LinkedList<User>(udao.searchuser(sname));
		request.setAttribute("foundusers", foundusers);
		request.setAttribute("searchuser", true);
		if(foundusers.size()==0 || sname.length()==0) {request.setAttribute("userfound", false);}
		else {request.setAttribute("userfound", true);}
		if(isadmin) {
		Group g=(Group) session.getAttribute("presentgroup");
		List<UserinGroup> suig = new LinkedList<> (UserinGroupImpl.usersinagroup(g,foundusers));
		request.setAttribute("searchlist", suig);
		}
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

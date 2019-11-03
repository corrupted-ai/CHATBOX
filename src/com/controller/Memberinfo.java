package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDaoImp;
import com.model.User;

/**
 * Servlet implementation class Memberinfo
 */
@WebServlet("/memberinfo")
public class Memberinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Memberinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		if(request.getParameter("myaccount")!= null) {
			User main=(User) session.getAttribute("user");
			session.setAttribute("memberchange",main);
			request.getRequestDispatcher("mygroups").forward(request, response);
			return;
		}
		String uid=request.getParameter("memberbutton");
		UserDaoImp udao=new UserDaoImp();
		User u=udao.find(uid);
		request.setAttribute("memberchange", u);
		request.getRequestDispatcher("preload").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

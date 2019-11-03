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
import com.model.User;


/**
 * Servlet implementation class Preload
 */
@WebServlet("/preload")
public class Preload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Preload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getAttribute("memberchange")!=null) {
			User iu=(User) request.getAttribute("memberchange");
			request.setAttribute("infouser", iu);
			request.getRequestDispatcher("main.jsp").forward(request, response);
			return;
		}
		HttpSession session = request.getSession();
		session.setAttribute("leftblock","common/info.jsp");
		session.setAttribute("rightbottom","common/members.jsp");
		session.setAttribute("righttop","common/search.jsp");
		session.setAttribute("middleblock","common/groupview.jsp");
		UserDaoImp udao=new UserDaoImp();
		List<User> users= new LinkedList<User>(udao.findAll());
		session.setAttribute("allusers", users);
		User u=(User) session.getAttribute("user");
		session.setAttribute("infouser", u);
		session.setAttribute("isadmin", false);
		request.getRequestDispatcher("mygroups").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

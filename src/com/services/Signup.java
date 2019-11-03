package com.services;

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
 * Servlet implementation class Signup
 */
@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		long phone=Long.parseLong(request.getParameter("phone"));
		String password=request.getParameter("password");
		UserDaoImp ud=new UserDaoImp();
		if(ud.emailpresent(email)) {
			request.setAttribute("exist", true);
			request.getRequestDispatcher("start.jsp").forward(request, response);
		}
		else{
		User u= new User(name, email, phone, password);
		String id=u.getId();
		UserDaoImp udao=new UserDaoImp();
		session.setAttribute("user", u);
		udao.create(u);
		request.getRequestDispatcher("preload").forward(request, response);
		}
	}
}

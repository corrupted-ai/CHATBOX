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
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String email=request.getParameter("loginemail");
		String password=request.getParameter("loginpassword");
		UserDaoImp udao=new UserDaoImp();
		if(!udao.emailpresent(email)) {
		request.setAttribute("notvalid", true);
		request.getRequestDispatcher("start.jsp").forward(request, response);
		}
		User u=udao.findByemail(email);
		String id=u.getId();
		String name=u.getName();
		if(udao.validate(email, password)) {
			session.setAttribute("user", u);
			request.getRequestDispatcher("preload").forward(request, response);
			}
		else {
			request.setAttribute("notvalid", true);
			request.getRequestDispatcher("start.jsp").forward(request, response);
		}
	}
}

package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PostDaoImpl;
import com.dao.UserDaoImp;
import com.model.Group;
import com.model.Post;
import com.model.User;

/**
 * Servlet implementation class Postamessage
 */
@WebServlet("/postamessage")
public class Postamessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Postamessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User u=(User) session.getAttribute("user");
		Group g= (Group) session.getAttribute("presentgroup");
		String post=request.getParameter("message");
		Post p= new Post(g, u, post);
		PostDaoImpl pdao=new PostDaoImpl();
		pdao.create(p);
		UserDaoImp udao= new UserDaoImp();
		udao.addPostToUser(u, p);
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

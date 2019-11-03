package com.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDaoImp;
import com.model.Post;
import com.model.User;

/**
 * Servlet implementation class Myposts
 */
@WebServlet("/myposts")
public class Myposts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myposts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			HttpSession session = request.getSession();
			session.setAttribute("isadmin", false);
			User u=(User) session.getAttribute("user");
			UserDaoImp udao=new UserDaoImp();
			try {
				List<Post> posts=udao.findAllPosts(u);
				Collections.sort(posts);
				Collections.reverse(posts);
				session.setAttribute("myposts", true);
				session.setAttribute("viewmyposts", posts);
				if(posts.size()==0) {session.setAttribute("myposts", false);}
				
			}
			catch (Exception e) {
				session.setAttribute("myposts", false);
			}
			session.setAttribute("middleblock","common/myposts.jsp");
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

package com.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.GroupDaoImp;
import com.model.Group;
import com.model.Post;

/**
 * Servlet implementation class Viewposts
 */
@WebServlet("/viewposts")
public class Viewposts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Viewposts() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		Group g = (Group) session.getAttribute("presentgroup");
		GroupDaoImp gdao = new GroupDaoImp();
		try {
			List<Post> posts = gdao.findAllPostsInGroup(g);
			Collections.sort(posts);
			Collections.reverse(posts);
			session.setAttribute("groupposts", posts);
			session.setAttribute("posted", true);
			if (posts.size() == 0) {
				session.setAttribute("posted", false);
			}
		} catch (Exception e) {
			session.setAttribute("posted", false);
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

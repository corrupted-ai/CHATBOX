package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.GroupDaoImp;
import com.model.Group;
import com.model.User;

/**
 * Servlet implementation class Creategroup
 */
@WebServlet("/creategroup")
public class Creategroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Creategroup() {
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
		HttpSession session =request.getSession();
		String gname=request.getParameter("gname");
		User u=(User) session.getAttribute("user");
		Group group=new Group(gname, u);
		GroupDaoImp gdao= new GroupDaoImp();
		gdao.create(group,u);
		String gid=group.getGid();
		session.setAttribute("presentgroup", group);
		request.setAttribute("groupid", gid);
		request.getRequestDispatcher("grouping").forward(request, response);
	}

}

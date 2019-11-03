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

import com.dao.GroupDaoImp;
import com.dao.UserDaoImp;
import com.model.Group;
import com.model.User;
import com.services.UserinGroup;
import com.services.UserinGroupImpl;

/**
 * Servlet implementation class Grouping
 */
@WebServlet("/grouping")
public class Grouping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Grouping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String gid =new String();
		HttpSession session = request.getSession();
		gid=(String) request.getAttribute("groupid");
		if(request.getParameter("viewgroup")!=null) {
			gid= (String) request.getParameter("viewgroup");
		}
		GroupDaoImp gdao=new GroupDaoImp();
		UserDaoImp udao = new UserDaoImp();
		Group g=gdao.find(gid);
		session.setAttribute("presentgroup", g);
		request.getRequestDispatcher("through").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

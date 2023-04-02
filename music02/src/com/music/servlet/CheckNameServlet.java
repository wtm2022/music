package com.music.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.service.CustomerServiceImp;

@WebServlet("/CheckName")
public class CheckNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CustomerServiceImp cs;
	
    public CheckNameServlet() {
        // TODO Auto-generated constructor stub
    	cs = new CustomerServiceImp();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charest=utf-8");
//		response.getWriter().print("«Î«Û≥…π¶£°");
		String name = request.getParameter("username");
		boolean f = cs.findCusByName(name);
		if(f) {
			response.getWriter().print("ok");
		}else {
			response.getWriter().print("no");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

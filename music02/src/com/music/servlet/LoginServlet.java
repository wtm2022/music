package com.music.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.entity.Customer;
import com.music.service.CustomerServiceImp;
import com.music.util.JsonResult;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerServiceImp cs;
	
	public LoginServlet() {
		cs = new CustomerServiceImp();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().write("<font color='red'>hello,servlet!!!</font>");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		boolean f = cs.findCusByLogin(new Customer(name, password));
		
		JsonResult jr = null;
		if(f) {
//			��¼�ɹ�ʱ��Ҫ����ɹ���¼���û���
//			request.getSession().setAttribute("loginName", name);
//			response.getWriter().write("<script>alert('��ϲ����¼�ɹ���');location.href='ok.html';</script>");
			jr = JsonResult.ok("��¼�ɹ�");
		}else {
			//response.getWriter().write("<script>alert('�Բ����û������������');location.href='index.html';</script>");
			jr = JsonResult.build(500,"�û����������",null);
		}
		JSONObject json = JSONObject.fromObject(jr);
		response.getWriter().print(json);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.music.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.entity.Music;
import com.music.service.MusicServiceImp;

import net.sf.json.JSONArray;

@WebServlet("/MusicServletAjax")
public class MusicServletAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MusicServiceImp ms;
	
    public MusicServletAjax() {
        ms = new MusicServiceImp();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Music> list = ms.findAllMusics();
		request.setAttribute("list", list);
		JSONArray json = JSONArray.fromObject(list);
		response.getWriter().print(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

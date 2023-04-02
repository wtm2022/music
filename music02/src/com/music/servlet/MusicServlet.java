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

/**
 * Servlet implementation class MusicServlet
 */
@WebServlet("/MusicServlet")
public class MusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private MusicServiceImp ms;
    
    public MusicServlet() {
        ms = new MusicServiceImp();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Music> list = ms.findAllMusics();
		request.setAttribute("list", list);
		request.getRequestDispatcher("showAllMusics.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

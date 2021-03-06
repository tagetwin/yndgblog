package com.yndg.board.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yndg.board.Action.Action;
import com.yndg.board.Action.Board.BoardFactory;
import com.yndg.board.Action.User.UserFactory;
import com.yndg.board.dao.UserDao;

@WebServlet("/board")
public class BoardController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String cmd = req.getParameter("cmd");
		Action action = BoardFactory.route(cmd);
		action.excute(req, resp);
		
	}
	
}

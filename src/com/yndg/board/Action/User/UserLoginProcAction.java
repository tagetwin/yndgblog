package com.yndg.board.Action.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yndg.board.Action.Action;
import com.yndg.board.dao.UserDao;

public class UserLoginProcAction implements Action{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String rememberMe = req.getParameter("rememberMe");
		
		UserDao userDao = UserDao.getInstance();
		userDao.login(username, password);
		
	}

}

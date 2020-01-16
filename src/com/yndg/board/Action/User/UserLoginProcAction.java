package com.yndg.board.Action.User;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yndg.board.Action.Action;
import com.yndg.board.Model.User;
import com.yndg.board.dao.UserDao;
import com.yndg.board.util.Script;

public class UserLoginProcAction implements Action{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(
				req.getParameter("username") == null ||
				req.getParameter("password") == null ||
				req.getParameter("rememberMe") == null ||
						req.getParameter("username").equals("") ||
						req.getParameter("password").equals("") ||
						req.getParameter("rememberMe").equals("")
				
		  ) {
			Script.back(resp, "잘못된 접근입니다.");
			return;
		}
			
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String rememberMe = Optional.ofNullable(req.getParameter("rememberMe")).orElse("off");
		
		System.out.println("username:" + username);
		System.out.println("password:" + password);
		System.out.println("rememberMe:" + rememberMe);
		
		UserDao userDao = UserDao.getInstance();
		User user = userDao.login(username, password);
		
//		User user = (User)req.getSession().getAttribute("user");
		
		if(user != null) {
			RequestDispatcher dis = req.getRequestDispatcher("/");
			dis.forward(req, resp);
		}else {
			Script.back(resp, "로그인이 실패하였습니다.");
		}
		
	}

}

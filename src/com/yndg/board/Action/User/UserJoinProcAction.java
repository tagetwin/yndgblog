package com.yndg.board.Action.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yndg.board.Action.Action;
import com.yndg.board.dao.UserDao;
import com.yndg.board.util.Script;

public class UserJoinProcAction implements Action{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		System.out.println("email:"+email);
		
		UserDao userDao = UserDao.getInstance();
		
		int result = userDao.save(username, password, email);
		System.out.println("result:"+result);
		
		if(result == 1) {
			RequestDispatcher dis = req.getRequestDispatcher("/");
			dis.forward(req, resp);
		}else {
			Script.back(resp, "회원가입 실패");
		}
		
	}

}

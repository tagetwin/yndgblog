package com.yndg.board.Action.User;

import com.yndg.board.Action.Action;

public class UserFactory {

	public static Action route(String cmd) {
		if(cmd.equals("join")) {
			return new UserJoinAction();
		}
		return null;
	}	
	
}

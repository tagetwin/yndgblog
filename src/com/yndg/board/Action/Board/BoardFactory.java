package com.yndg.board.Action.Board;

import com.yndg.board.Action.Action;

public class BoardFactory {

	public static Action route(String cmd) {
		if(cmd.equals("list")) {
			return new BoardListAction();
		}
		return null;
	}	
	
}

package com.yndg.board.Action.Board;

import com.yndg.board.Action.Action;

public class BoardFactory {

	public static Action route(String cmd) {
		if(cmd.equals("list")) {
			return new BoardListAction();
		}else if(cmd.equals("detail")) {
			return new BoardDetailAction();
		}else if(cmd.equals("update")) {
			return new BoardUpdateAction();
		}else if(cmd.equals("delete")) {
			return new BoardDeleteAction();
		}else if(cmd.equals("write")) {
			return new BoardWriteAction();
		}
		return null;
	}	
	
}

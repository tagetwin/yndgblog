package com.yndg.board.Model;

import java.sql.Timestamp;

public class Board {
	private int id;
	private String title;
	private String content;
	private int userID;
	private Timestamp createTime;
	
	public Board(int id, String title, String content, int userID, Timestamp createTime) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.userID = userID;
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
}

package com.yndg.board.Model;

import java.sql.Timestamp;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private Timestamp createTime;
	
	public User(int id, String username, String password, String email, Timestamp createTime) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
}

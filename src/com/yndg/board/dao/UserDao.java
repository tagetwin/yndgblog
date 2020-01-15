package com.yndg.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.yndg.board.DB.DBUtil;
import com.yndg.board.Model.User;

public class UserDao {

	private UserDao() {
	}

	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	public int save(String username, String password, String email) {

		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;

		try {
			final String SQL = "INSERT INTO user (username, password, email, createTime) VALUES (?, ?, ?, now())";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);

			int result = pstmt.executeUpdate();

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	public int update(String password) {

		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;

		try {
			final String SQL = "UPDATE user SET password = ? WHERE id =?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, password);
			pstmt.setInt(2, 2);

			int result = pstmt.executeUpdate();

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	public int delete() {

		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;

		try {
			final String SQL = "DELETE FROM user WHERE id = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, 2);

			int result = pstmt.executeUpdate();

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	public List<User> findAll() {
		List<User> users = new ArrayList<User>();

		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			final String SQL = "SELECT * FROM user";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				Timestamp createTime = rs.getTimestamp("createTime");

				User user = new User(id, username, password, email, createTime);
				users.add(user);
			}

			return users;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public User findById() {

		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			final String SQL = "SELECT * FROM user WHERE id = ?";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			User user = null;

			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				Timestamp createTime = rs.getTimestamp("createTime");

				user = new User(id, username, password, email, createTime);

			}

			return user;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public User login(String username, String password) {

		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			final String SQL = "SELECT * FROM user WHERE username = ? and password = ? ";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			User user = null;

			while (rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
				Timestamp createTime = rs.getTimestamp("createTime");

				user = new User(id, username, password, email, createTime);

			}

			return user;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}

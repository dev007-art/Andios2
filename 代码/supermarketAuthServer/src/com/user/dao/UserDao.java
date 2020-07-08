package com.user.dao;

import com.user.bean.User;

import java.sql.SQLException;

public interface UserDao {
	public User getUser(String userName, String passWord) throws SQLException;

}

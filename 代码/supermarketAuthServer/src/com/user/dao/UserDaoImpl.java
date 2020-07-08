package com.user.dao;

import java.sql.*;

import com.common.util.DataConnection;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.user.bean.User;

public class UserDaoImpl implements UserDao {
	DataConnection connection = new DataConnection();
	Connection conn = null;
	PreparedStatement statement=null;
	ResultSet resultSet=null;
	//将return null修改为实现登录操作的代码
	@Override
	public User getUser(String userName, String passWord) throws SQLException {
		User user = new User();
		if(userName==null||passWord==null){
			return null;
		}
		    conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/andios","root","111");
			String sql = "select * from user where username='"+userName+"' and password='"+passWord+"'";
		    statement = conn.prepareStatement(sql);
		    resultSet = statement.executeQuery();
		if(resultSet.next()){
				user.setUserName(userName);
				user.setPassWord(passWord);
				return user;
			}else {
		    	return null;
		}
	}

}
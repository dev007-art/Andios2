package com.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataConnection {
	private Connection conn;
	private PreparedStatement pstm;
	//填写代码
	private String user = "root";
	private String password = "111";
	private String driverClassName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/andios?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";

	public DataConnection() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			System.out.println("	加载数据库驱动失败！");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("创建数据库连接失败！");
			conn = null;
			e.printStackTrace();
		}
		return conn;
	}

	public void doPstm(String sql, Object[] params) {
		if (sql != null && !(sql.trim().equals(""))) {
			if (params == null) {
				params = new Object[0];
				getConnection();
				if (conn != null) {
					try {
						System.out.println(sql);
						pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
						for (int i = 0; i < params.length; i++) {
							pstm.setObject(i + 1, params[i]);
						}
						pstm.execute();
					} catch (SQLException e) {
						System.out.println("doPstm()方法出错！");
						e.printStackTrace();
					}
				}
			}
		}
	}

	public ResultSet getResultSet() throws SQLException {
		return pstm.getResultSet();
	}

	public int getCount() throws SQLException {
		return pstm.getUpdateCount();
	}

	public void closed() {
		try {
			if (pstm != null) {
				pstm.close();
			}
		} catch (SQLException e) {
			System.out.println("关闭pstm对象失败！");
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("关闭conn对象失败！");
			e.printStackTrace();
		}
	}

}

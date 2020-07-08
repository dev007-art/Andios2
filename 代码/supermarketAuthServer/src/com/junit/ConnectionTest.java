package com.junit;

import com.common.util.DBUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {
    @Test
    public void testConnection() throws SQLException {
        Connection connection = DBUtil.getConnection();
        System.out.println(connection);
    }
}

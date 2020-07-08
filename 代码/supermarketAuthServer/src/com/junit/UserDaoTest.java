package com.junit;

import com.user.bean.User;
import com.user.dao.UserDao;
import com.user.dao.UserDaoImpl;
import org.junit.Test;

import java.sql.SQLException;


public class UserDaoTest {
    @Test
    //测试UserDao
    public void testLogin() throws SQLException {
        UserDao userDao = new UserDaoImpl();
        User zhangsan = userDao.getUser("zhangsan", "12");
        System.out.println(zhangsan);
    }

}

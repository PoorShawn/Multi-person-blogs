package org.poorman.blogs.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.poorman.blogs.dao.UserDAO;
import org.poorman.blogs.dao.impl.UserDAOImpl;
import org.poorman.blogs.entity.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DruidPool {
    private static final DruidDataSource dataSource;

    static {
        dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // MySQL驱动类名
        dataSource.setUrl("jdbc:mysql://localhost:3306/blogs");
        dataSource.setUsername("root");
        dataSource.setPassword("123");
        // 可以根据需要设置更多配置
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
    }

    public static DruidDataSource getDataSource() {
        return dataSource;
    }

}

package org.poorman.blogs.util;

import com.alibaba.druid.pool.DruidDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DruidPool {
    static DruidDataSource dataSource = new DruidDataSource();

    static {
        Properties props = new Properties();
        InputStream fis = DruidPool.class.getClassLoader().getResourceAsStream("druid.properties");
        try (fis) {
            if (fis == null) {
                throw new RuntimeException("Cannot find druid.properties in classpath.");
            }
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file.", e);
        }

        dataSource.setDriverClassName(props.getProperty("driverClassName"));
        dataSource.setUrl(props.getProperty("url"));
        dataSource.setUsername(props.getProperty("username"));
        dataSource.setPassword(props.getProperty("password"));

        dataSource.setInitialSize(Integer.parseInt(props.getProperty("initialSize")));
        dataSource.setMaxWait(Integer.parseInt(props.getProperty("maxWait")));
        dataSource.setMaxActive(Integer.parseInt(props.getProperty("maxActive")));
    }

        public static DruidDataSource getDataSource() {
        return dataSource;
    }

//  public static void main(String[] args) {
//        DruidDataSource dataSource = loadDataSourceFromProperties();
//        try (Connection conn = dataSource.getConnection()) {
//            System.out.println("数据库连接成功：" + conn);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}

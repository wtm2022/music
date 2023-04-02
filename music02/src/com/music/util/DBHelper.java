package com.music.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBHelper {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        // 方式一： 读取db.properties里的相关信息
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        url = bundle.getString("jdbc.url");
        user = bundle.getString("jdbc.user");
        password = bundle.getString("jdbc.password");
        driver = bundle.getString("jdbc.driver");

        try {
            // 以反射的方式,把驱动类加载进内存,开成大Class对象.
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("---- 驱动加载成功 ----");
    }

    public static Connection getConnection(){
        try {
            return  DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

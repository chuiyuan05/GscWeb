package com.woaigsc.db;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by chuiyuan on 16-4-25.
 * 工具类，一般不要实例化，此时可以采用单例设计模式，或者将构造方法私有化
 */
public class DBHelper {
    public static String url ;
    public static String username ;
    public static String password;
    public static String driver ;

    private static ResourceBundle rb =
            ResourceBundle.getBundle("config/db-config");

    private DBHelper(){

    }
    /**
     * 为避免重复代码，使用静态代码块：只会在类加载的时候执行一次。
     */
    static {
        try {
            url = rb.getString("jdbc.url");
            username = rb.getString("jdbc.username");
            password = rb.getString("jdbc.password");
            driver = rb.getString("jdbc.driver");

            Class.forName(driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn = null ;
        try {
            conn = DriverManager.getConnection(url,username,password) ;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    /**
     *
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs , Statement stmt , Connection conn ){
        try{
            if (rs !=null) rs.close();
            if( stmt!= null) stmt.close();
            if(conn!= null)  conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

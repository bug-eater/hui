package com.javaweb.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
  private static Properties props;

  static {
    try {
      props=new Properties();
      InputStream in=DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
      props.load(in);
      Class.forName(props.getProperty("driver"));
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }
  public  static Connection getConnection(){
    Connection conn=null;
    try {
      conn= DriverManager.getConnection(props.getProperty("url"),
              props.getProperty("username"),
              props.getProperty("password"));
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {

    }
    return conn;
  }

  public static void close(Connection conn, PreparedStatement ps, ResultSet rs){

    if (rs != null) {
      try {
        rs.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    if (ps != null) {
      try {
        ps.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

}

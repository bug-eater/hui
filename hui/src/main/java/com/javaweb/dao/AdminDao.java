package com.javaweb.dao;

import com.javaweb.pojo.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class AdminDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public Admin selectAdmin(String username, String password) {
        Admin an = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from admin where name=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setInt(2, Integer.valueOf(password));
            System.out.println(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                an = new Admin();
                an.setID(rs.getInt(1)); // 根据字段索引获取值
                an.setName(rs.getString("name")); // 根据字段名获取值
                an.setCreateDate(new Date(rs.getDate("date").getTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return an;
    }

    public void update(String username) {
        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE  admin set date =now() where name=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"username");
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }
    }
}

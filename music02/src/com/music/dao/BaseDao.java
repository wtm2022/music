package com.music.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    
	private Connection conn;
    private PreparedStatement ps;
    private ResultSet set;

    public int[] updateMore(Connection conn, String sql, Object[][] objs) throws SQLException {
        this.conn = conn;
        this.ps = conn.prepareStatement(sql);
        for(int i = 0; i<objs.length; i++){
            for(int j = 0; j<objs[i].length; j++){
                ps.setObject(j + 1, objs[i][j]);
            }
            ps.addBatch();
        }
        return ps.executeBatch();
    }


    public int updateData(Connection conn, String sql, Object... objs) throws SQLException {
        this.conn = conn;
        this.ps = conn.prepareStatement(sql);
        for (int i = 0; i < objs.length; i++) {
            this.ps.setObject(i + 1, objs[i]);
        }
        return this.ps.executeUpdate();
    }
    public ResultSet selectData(Connection conn, String sql, Object... objs) throws SQLException {
        this.conn = conn;
        this.ps = conn.prepareStatement(sql);
        for (int i = 0; i < objs.length; i++) {
            ps.setObject(i + 1, objs[i]);
        }
        this.set =  ps.executeQuery();
        return this.set;
    }

    public void closeAll(){
        try {
            if (set != null) {
                set.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("---- close all ----");
    }

}

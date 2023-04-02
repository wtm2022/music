package com.music.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MusicDaoImp extends BaseDao implements MusicDao{
	
	@Override
	public ResultSet selectAllMusics(Connection conn) throws SQLException {
		String sql = "select * from music";
		return super.selectData(conn, sql);
	}
}

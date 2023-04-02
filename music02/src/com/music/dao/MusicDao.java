package com.music.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface MusicDao {
	ResultSet selectAllMusics(Connection conn)throws SQLException;
}

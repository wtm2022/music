package com.music.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.music.entity.Customer;

public interface CustomerDao {
	ResultSet selectCusByLogin(Connection conn,Customer cus)throws SQLException;
	
	ResultSet selectCusByName(Connection conn,String name)throws SQLException;
}

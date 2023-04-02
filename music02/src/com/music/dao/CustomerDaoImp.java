package com.music.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.music.entity.Customer;

public class CustomerDaoImp  extends BaseDao implements CustomerDao{

	@Override
	public ResultSet selectCusByLogin(Connection conn, Customer cus) throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select * from customer where customer_name=? and customer_password =?";
		return super.selectData(conn, sql, cus.getCustomer_name(),cus.getCustomer_password());
	}
	@Override
	public ResultSet selectCusByName(Connection conn, String name) throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select * from customer where customer_name=? ";
		return super.selectData(conn, sql, name);
	}
}

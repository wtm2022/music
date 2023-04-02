package com.music.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.music.dao.CustomerDaoImp;
import com.music.entity.Customer;
import com.music.util.DBHelper;

public class CustomerServiceImp implements CustomerService{
	private CustomerDaoImp cd;
	
	public CustomerServiceImp() {
		cd=new CustomerDaoImp();
	}

	@Override
	public boolean findCusByLogin(Customer cus) {
		// TODO Auto-generated method stub
		Connection conn =DBHelper.getConnection();
		try {
			ResultSet set =cd.selectCusByLogin(conn,cus);
			if(set.next()) {
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cd.closeAll();
		}
		return false;
	}
	@Override
	public boolean findCusByName(String name) {
		// TODO Auto-generated method stub
		Connection conn =DBHelper.getConnection();
		try {
			ResultSet set =cd.selectCusByName(conn,name);
			if(set.next()) {
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cd.closeAll();
		}
		return false;
	}
}

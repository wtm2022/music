package com.music.test;

import org.junit.Test;

import com.music.entity.Customer;
import com.music.service.CustomerServiceImp;

public class TestAll {
	@Test
	public void login() {
		String customer_name ="jack";
		String customer_password ="1234";
		
		CustomerServiceImp cs =new CustomerServiceImp();
		boolean f =cs.findCusByLogin(new Customer(customer_name,customer_password));
		if(f) {
			System.out.println("登陆成功");
		}else {
			System.out.println("用户名或密码错误");
		}
		
	}
}

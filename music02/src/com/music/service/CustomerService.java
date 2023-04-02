package com.music.service;

import com.music.entity.Customer;

public interface CustomerService {
	boolean findCusByLogin(Customer cus);
	
	boolean findCusByName(String name);
}

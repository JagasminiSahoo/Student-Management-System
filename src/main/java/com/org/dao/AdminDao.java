package com.org.dao;

import java.util.List;

import com.org.dto.Admin;

public interface AdminDao {
	
	void saveAndUpdate(Admin admin);
	
	Admin fetchAdminById(int id);
	
	List<Admin> verifyAdminByEmailAndPwd(String email,String password);

}

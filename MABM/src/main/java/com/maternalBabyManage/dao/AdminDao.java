package com.maternalBabyManage.dao;

import com.maternalBabyManage.domain.Admin;

public interface AdminDao {

	public Admin selectAdminByName(String name);
	public Admin selectAdminById(int id);
}

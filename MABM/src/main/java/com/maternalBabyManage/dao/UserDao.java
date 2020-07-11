package com.maternalBabyManage.dao;

import java.util.List;

import com.maternalBabyManage.domain.User;

public interface UserDao {
	
	public User selectUserByName(String userName);
	public User selectUserById(int id);
	public void addUser(User user);
	public void updateUser(User user,String babysitterNamelist );
	public void deleteUserByName(String userName);
	public void deleteUserById(int id);
	public User selectUserByBabysitterName(String babysitterName );
	public List<User> selectUserList(int pageNo,int pageSize);
	public int selectUserCount();
}

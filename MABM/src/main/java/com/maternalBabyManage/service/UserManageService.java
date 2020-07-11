package com.maternalBabyManage.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maternalBabyManage.dao.UserDao;
import com.maternalBabyManage.domain.User;

@Service
public class UserManageService {
	
	@Autowired 
	UserDao userDao;
	public List<User> getUserList(Map<String,String> map){
		
		int pageNo = map.get("pageNo") == null ? 0 : Integer.parseInt(map.get("pageNo")+"")-1;
		int pageSize = map.get("pageSize") == null ? 10 : Integer.parseInt(map.get("pageSize")+"");
		List<User> userlist = userDao.selectUserList(pageNo*pageSize,pageSize);
		return userlist;
	}
	public int getUserListCount () {
		return userDao.selectUserCount();
	}
	
	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
	}
	
	public User selectUserById(int id) {
		return userDao.selectUserById(id);
	}
	
	public User selectUserByName(String name) {
		return userDao.selectUserByName(name);
	}
	
	public void updateUser(User user,String babysitterNamelist) {
		userDao.updateUser(user,babysitterNamelist);
	}

}

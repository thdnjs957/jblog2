package com.cafe24.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.BlogDao;
import com.cafe24.jblog.repository.UserDao;
import com.cafe24.jblog.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;
	
	public boolean join(UserVo userVo) {
		
		String id = userVo.getId();
		boolean userInsertResult = userDao.insert(userVo);
		if(userInsertResult) {
			boolean blogInsertResult = blogDao.insert(id);
			if(blogInsertResult){
				return true;
			}
		}
		return false;
	}
	
	public UserVo getUser(UserVo userVo) {
		
		return userDao.get(userVo.getId(), userVo.getPassword());
		
	}

	
}

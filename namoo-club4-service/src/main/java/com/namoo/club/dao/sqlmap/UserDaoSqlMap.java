package com.namoo.club.dao.sqlmap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.club.dao.UserDao;
import com.namoo.club.dao.sqlmap.mapper.UserMapper;
import com.namoo.club.domain.SocialPerson;

@Repository
public class UserDaoSqlMap implements UserDao {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<SocialPerson> readAllUsers() {
		//
		return userMapper.selectAllUsers();
	}

	@Override
	public SocialPerson readUser(String email) {
		//
		return userMapper.selectUser(email);
	}

	@Override
	public void createUser(SocialPerson person) {
		//
		userMapper.insertUser(person);
	}

	@Override
	public void updateUser(SocialPerson person) {
		//
		userMapper.updateUser(person);
	}

	@Override
	public void deleteUser(String email) {
		//
		userMapper.deleteUser(email);
	}

}

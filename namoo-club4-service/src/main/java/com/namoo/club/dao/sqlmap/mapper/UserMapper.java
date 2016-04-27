package com.namoo.club.dao.sqlmap.mapper;

import java.util.List;

import com.namoo.club.domain.SocialPerson;

public interface UserMapper {

	List<SocialPerson> selectAllUsers();
	 
	SocialPerson selectUser(String email);
	 
	void insertUser(SocialPerson person);
	 
	void updateUser(SocialPerson person);
	 
	void deleteUser(String email);
	
}

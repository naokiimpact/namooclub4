package com.namoo.club.dao.sqlmap.mapper;

import java.util.List;

import com.namoo.club.domain.Community;

public interface CommunityMapper {
	//
	List<Community> selectAllCommunities();
	Community selectCommunity(int communityNo);
	int createCommunity(Community community);
	void updateCommunity(Community community);
	void deleteCommunity(int communityNo);
}
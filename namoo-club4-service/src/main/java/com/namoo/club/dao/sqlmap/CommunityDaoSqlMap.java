package com.namoo.club.dao.sqlmap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.club.dao.CommunityDao;
import com.namoo.club.dao.sqlmap.mapper.CommunityMapper;
import com.namoo.club.domain.Community;

@Repository
public class CommunityDaoSqlMap implements CommunityDao {
	//
	@Autowired
	private CommunityMapper communityMapper;

	@Override
	public List<Community> readAllCommunities() {
		//
		return communityMapper.selectAllCommunities();
	}

	@Override
	public Community readCommunity(int communityNo) {
		//
		return communityMapper.selectCommunity(communityNo);
	}

	@Override
	public int createCommunity(Community community) {
		//
		communityMapper.createCommunity(community);
		return community.getId();
	}

	@Override
	public void updateCommunity(Community community) {
		//
		communityMapper.updateCommunity(community);
	}

	@Override
	public void deleteCommunity(int communityNo) {
		//
		communityMapper.deleteCommunity(communityNo);
	}
}

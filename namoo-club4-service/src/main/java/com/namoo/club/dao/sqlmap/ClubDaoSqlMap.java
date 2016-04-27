package com.namoo.club.dao.sqlmap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.club.dao.ClubDao;
import com.namoo.club.dao.sqlmap.mapper.ClubMapper;
import com.namoo.club.domain.Club;
import com.namoo.club.dto.Member;

@Repository
public class ClubDaoSqlMap implements ClubDao {

	@Autowired
	private ClubMapper clubMapper;
	
	@Override
	public List<Club> readAllClubByCommunityId(int communityId) {
		//
		return clubMapper.selectAllClubByCommunityId(communityId);
	}

	@Override
	public Club readClub(int id) {
		//
		return clubMapper.selectClub(id);
	}

	@Override
	public List<Member> readAllClubMembersById(int id) {
		//
		return clubMapper.selectAllClubMembersById(id);
	}

	@Override
	public int createClub(int communityNo, Club club, int categoryNo) {
		//
		clubMapper.createClub(communityNo, club, categoryNo);
		return club.getId();
	}

	@Override
	public void updateClub(Club club) {
		//
		clubMapper.updateClub(club);
	}

	@Override
	public void deleteClub(int id) {
		//
		clubMapper.deleteClub(id);
	}

}

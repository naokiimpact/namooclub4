package com.namoo.club.dao.sqlmap.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.namoo.club.domain.Club;
import com.namoo.club.dto.Member;

public interface ClubMapper {
	//
	List<Club> selectAllClubByCommunityId(int communityId);

	Club selectClub(int id);

	List<Member> selectAllClubMembersById(int id);


	int createClub(@Param("communityNo") int communityNo, @Param("club") Club club, @Param("categoryNo") int categoryNo);


	void updateClub (Club club);


	void deleteClub (int id);
}

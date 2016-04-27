package com.namoo.club.dao.sqlmap.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.namoo.club.dto.Member;

public interface MemberMapper {
	//
	List<Member> selectAllMembers();

	List<Member> selectMembersByPerson(String email);
	
	List<Member> selectMemberByGroup(@Param("groupNo") int groupNo, @Param("groupType") int groupType);

	void insertMember(Member member);

	void updateMember(Member member);

	void deleteMember(Member member);

	Member selectMember(@Param("email") String email, @Param("groupNo") int groupNo, @Param("groupType") int groupType);

	List<Member> selectManager(@Param("groupNo") int groupNo, @Param("groupType")  int groupType);

	List<Member> selectMemberByCommunity(@Param("email") String email,  @Param("communityNo") int communityNo);
}

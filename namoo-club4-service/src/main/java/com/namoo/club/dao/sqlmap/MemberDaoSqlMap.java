package com.namoo.club.dao.sqlmap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.club.dao.MemberDao;
import com.namoo.club.dao.sqlmap.mapper.MemberMapper;
import com.namoo.club.dto.Member;

@Repository
public class MemberDaoSqlMap implements MemberDao {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public List<Member> readAllMembers() {
		//
		return memberMapper.selectAllMembers();
	}

	@Override
	public List<Member> readMembersByPerson(String email) {
		//
		return memberMapper.selectMembersByPerson(email);
	}

	@Override
	public List<Member> readMemberByGroup(int groupNo, int groupType) {
		//
		return memberMapper.selectMemberByGroup(groupNo, groupType);
	}

	@Override
	public void createMember(Member member) {
		//
		memberMapper.insertMember(member);
	}

	@Override
	public void updateMember(Member member) {
		//
		memberMapper.updateMember(member);
	}

	@Override
	public void deleteMember(Member member) {
		//
		memberMapper.deleteMember(member);
	}

	@Override
	public Member readMember(String email, int groupNo, int groupType) {
		//
		return memberMapper.selectMember(email, groupNo, groupType);
	}

	@Override
	public List<Member> findManager(int groupNo, int groupType) {
		//
		return memberMapper.selectManager(groupNo, groupType);
	}

	@Override
	public List<Member> readMemberByCommunity(String email, int communityNo) {
		//
		return memberMapper.selectMemberByCommunity(email, communityNo);
	}

}

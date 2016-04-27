package com.namoo.club.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.namoo.club.domain.Club;
import com.namoo.club.domain.Community;
import com.namoo.club.domain.CommunityMember;
import com.namoo.club.domain.SocialPerson;
import com.namoo.club.service.facade.ClubService;
import com.namoo.club.service.facade.CommunityService;
import com.namoo.club.service.facade.TownerService;
import com.namoo.club.web.session.LoginRequired;
import com.namoo.club.web.session.SessionManager;
import com.namoo.club.web.util.MessageUtility;

@Controller
@LoginRequired
public class CommunityController {
	
	@Autowired
	private CommunityService communityService;
	@Autowired
	private ClubService clubService;
	@Autowired
	private TownerService townerService;

	@RequestMapping("/main")
	@LoginRequired(false)
	public String main(HttpServletRequest req, Model model) {
		//
		String email = SessionManager.getInstance(req).getLoginId();

		List<Community> communityList = communityService.findAllCommunities();
		if (email == null) {

			model.addAttribute("community_list", communityList);
		} else {

			List<Community> myCommunityList = communityService.findBelongCommunities(email);
			
//			for (Community community : myCommunityList) {
//				System.out.println(community.getName());
//				List<CommunityMember> members = community.getMembers();  
//				System.out.println(members.size());
//				for (CommunityMember communityMember : members) {
//					System.out.println(communityMember.getMember().getEmail());
//					System.out.println(communityMember.getMember().getName());
//				}
//				
//			}
			List<Community> removes = new ArrayList<Community>();

			for(Community community : communityList){
				for (Community myCommunity : myCommunityList) {
					if (community.getId() == myCommunity.getId()) {
						removes.add(community);
					}
				}
			}
			communityList.removeAll(removes);
			model.addAttribute("my_community_list", myCommunityList);
			model.addAttribute("not_my_community_list", communityList);
		}
		return "main";
	}
	
	@RequestMapping("/community/main")
	@LoginRequired(false)
	public String communityMain(HttpServletRequest req, Model model, 
			@RequestParam("community_id") int communityId) {
		//
		String email = SessionManager.getInstance(req).getLoginId();

		Community community = communityService.findCommunity(communityId);
		List<Club> clubList = clubService.findAllClubs(communityId);
		
		if (email == null) {
			//
			model.addAttribute("club_list", clubList);
		} else {
			//
			List<Club> myClubList = clubService.findBelongClubs(communityId, email);
			List<Club> removes = new ArrayList<Club>();

			for(Club club : clubList){
				for (Club myClub : myClubList) {
					if (club.getId() == myClub.getId()) {
						removes.add(club);
					}
				}
			}
			clubList.removeAll(removes);
			
			model.addAttribute("community_id", communityId);
			model.addAttribute("community", community);
			model.addAttribute("my_club_list", myClubList);
			model.addAttribute("not_my_club_list", clubList);
		}
		return "/community/main";
	}
	
	@RequestMapping(value = "/community/open")
	public String openCommunity() {
		return "community/open";
	}
	
	@RequestMapping("/community/open.do")
	public String openCommunityProcess(HttpServletRequest req, Community community,
			String[] categories) {
		//
		String loginId = SessionManager.getInstance(req).getLoginId();
		SocialPerson person = townerService.findTowner(loginId);

		String email = person.getEmail();
		List<String> categoryList = new ArrayList<String>();
		
		for (int i = 0; i < categories.length; i++) {
			//
			if(!categories[i].equals("")) {
				//
				categoryList.add(categories[i]);
			}
		}
		communityService.registCommunity(community.getName(), 
				community.getDescription(), email, categoryList);

		return "redirect:/main";
	}
	
	@RequestMapping(value = "/community/join")
	public String joinCommunity(Model model) {
		//
		String url = "community/join.do";
		String msg = "커뮤니티에 가입하시겠습니까?";
		
		return MessageUtility.getInstance().showInfo(model, msg, url);
		
	}
	
	@RequestMapping("/community/join.do")
	public String joinCommunity(HttpServletRequest req, @RequestParam("community_id") int communityId) {
		//
		String loginId =  SessionManager.getInstance(req).getLoginId();

		communityService.joinAsMember(communityId, loginId);
		
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/community/remove")
	public String removeCommunity(Model model, 
			@RequestParam(value = "mypage", required = false) String mypage) {
		//
		String url = "community/remove.do";
		String msg = "커뮤니티를 삭제하시겠습니까?";
		
		model.addAttribute("mypage", mypage);
		
		return MessageUtility.getInstance().showInfo(model, msg, url);
	}
	
	@RequestMapping("/community/remove.do")
	public String removeCommunity(@RequestParam("community_id") int communityId, 
			@RequestParam(value = "mypage", required = false) String mypage) {
		//		
		communityService.removeCommunity(communityId);
		
		if (("true").equals(mypage)) {
			return "redirect:/user/mypage";
		} else {
			return "redirect:/main";
		}
	}
	
	@RequestMapping(value = "/community/withdrawal")
	public String withdrawalCommunity(Model model, 
			@RequestParam(value = "mypage", required = false) String mypage) {
		//
		String url = "community/withdrawal.do";
		String msg = "커뮤니티를 탈퇴하시겠습니까?";
		
		return MessageUtility.getInstance().showInfo(model, msg, url);
	}
	
	@RequestMapping("/community/withdrawal.do")
	public String withdrawalCommunity(HttpServletRequest req, 
			@RequestParam("community_id") int communityId, 
			@RequestParam(value = "mypage", required = false) String mypage) {
		//
		String email =  SessionManager.getInstance(req).getLoginId();

		communityService.withdrawalCommunity(communityId, email);
		
		if (("true").equals(mypage)) {
			return "redirect:/user/mypage";
		} else {
			return "redirect:/main";
		}
	}
}

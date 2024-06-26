package com.jdy.mybatis.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdy.mybatis.dao.MemberDao;
import com.jdy.mybatis.dto.MemberDto;

@Controller
public class MemberController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		memberDao.joinMemberDao(mid, mpw, mname, memail);
		
		model.addAttribute("mid", mid);
		model.addAttribute("mname", mname);
		
		return "joinOk";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping(value = "/loginOk")
	public String loginOk(HttpServletRequest request, HttpSession session, Model model) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		int loginFlag = memberDao.loginDao(mid, mpw);
		
		if( loginFlag == 1) {
			session.setAttribute("sessionid", mid);
			model.addAttribute("loginid",mid);
			return "loginOk";
		} else {
			model.addAttribute("loginFail", "아이디와 비밀번호를 다시 확인해주세요.");
			return "login";
		}	
	}
	
	@RequestMapping(value = "/search")
	public String search() {
		return "search";
	}
	
	
	@RequestMapping(value = "/searchOk")
	public String searchOk(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("mid");
		
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		MemberDto memberDto = memberDao.searchDao(mid);
		
		MemberDto memberDto2 = new MemberDto();
		
		if(memberDto != null) {
			model.addAttribute("memberDto",memberDto);
		} else {
			model.addAttribute("searchFail","회원검색에 실패하였습니다.");
		}
		return "searchOk";
	}
	
	@RequestMapping(value = "/deletet")
	public String delete() {
		return "delete";
	}
	
	
	@RequestMapping(value = "/deleteOk")
	public String deleteOk(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("mid");
		
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		int success = memberDao.deleteMemberDao(mid);
		
		if(success == 1) {
			return "redirect:memberlist";
		} else {
			model.addAttribute("deleteFail","존재하지 않는 회원입니다.");
			return "delete";
		}
		
	}
}

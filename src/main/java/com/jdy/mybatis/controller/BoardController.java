package com.jdy.mybatis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdy.mybatis.dao.BoardDao;
import com.jdy.mybatis.dao.MemberDao;
import com.jdy.mybatis.dto.MemberDto;

@Controller
public class BoardController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/write")
	public String write(HttpSession session, Model model) {
		
		String sessionid = (String) session.getAttribute("sessionid");
		
		if(sessionid == null) {
			model.addAttribute("lodinFail", "글쓰기는 로그인되어야 가능합니다.");
			return "login";
		} else {			
			MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
			MemberDto memberDto = memberDao.searchDao(sessionid);
			
			model.addAttribute("mid", sessionid);			
			model.addAttribute("mname", memberDto.getMname());
			
			return "write_form";
		}
	}
	
	@RequestMapping(value = "/writeOk")
	public String writeOk(HttpServletRequest request, Model model) {
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.writeDao(request.getParameter("bid"), request.getParameter("bname"), request.getParameter("btitle"), request.getParameter("bcontent"));
			
		return "redirect:list";
	}
	
	
	
	
}

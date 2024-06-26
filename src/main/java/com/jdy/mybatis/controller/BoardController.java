package com.jdy.mybatis.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdy.mybatis.dao.BoardDao;
import com.jdy.mybatis.dao.MemberDao;
import com.jdy.mybatis.dto.BoardDto;
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
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, Model model) {
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> boardDtos = boardDao.boardListDao();
		
		model.addAttribute("boardList", boardDtos);
		
		return "boardlist";
	}
	
	@RequestMapping(value = "/contentView")
	public String contentView(HttpServletRequest request, Model model, HttpSession session) {
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		BoardDto boardDto = boardDao.contentViewDao(request.getParameter("bnum"));
		
		String sessionid = (String) session.getAttribute("sessionid");
		
		// System.out.println("세션아이디:" + sessionid);
		
		int idCheck = 0;
		
		if((sessionid !=null) && (boardDto.getBid().equals(sessionid))) {
			idCheck = 1;			
		} else {
			
		}
		
		
		model.addAttribute("idCheck", idCheck);
		model.addAttribute("boardDto", boardDto);
		
		return "content_view";
	}
	
	@RequestMapping(value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		BoardDto boardDto = boardDao.contentViewDao(request.getParameter("bnum"));
		
		model.addAttribute("boardDto", boardDto);
		
		return "modify_form";
	}
	
	@RequestMapping(value = "/modifyOk")
	public String modifyOk(HttpServletRequest request, Model model) {
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.modifyDao(request.getParameter("btitle"), request.getParameter("bcontent"), request.getParameter("bnum"));
		
		return "redirect:list";
	}
	
	
	
}

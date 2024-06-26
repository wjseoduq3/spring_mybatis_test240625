package com.jdy.mybatis.dao;

import java.util.ArrayList;

import com.jdy.mybatis.dto.BoardDto;

public interface BoardDao {
	
	public  void writeDao(String bid, String bname, String btitle, String bcontent);
	public ArrayList<BoardDto> boardListDao();
	public BoardDto contentViewDao(String bnum);
	public void modifyDao(String btitle, String bcontent, String bnum);
	public void uphitDao(String bnum);
	public void deleteDao(String bnum);
	
}

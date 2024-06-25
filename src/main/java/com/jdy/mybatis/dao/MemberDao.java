package com.jdy.mybatis.dao;

import com.jdy.mybatis.dto.MemberDto;

public interface MemberDao {
	
	public void joinMemberDao(String mid, String mpw, String mname, String memail);	
	public int loginDao(String mid, String mpw);
	public MemberDto searchDao(String mid);
	
}

package com.edu.member.service;

import com.edu.member.vo.MemberVo;

public interface MemberService {

	
	
	
	public MemberVo memberExist(MemberVo memberVo);
	public void memberInsertOne(MemberVo memberVo);
	public MemberVo memberSelectOne(int no);
	public int memberUpdateOne(MemberVo memberVo);
	
}

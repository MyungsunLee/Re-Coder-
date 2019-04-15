package com.edu.member.service;

import java.util.Map;

import com.edu.member.vo.MemberVo;

public interface MemberService {

	
	
	
	public MemberVo memberExist(MemberVo memberVo);
	public void memberInsertOne(MemberVo memberVo);
	public Map<String, Object> memberSelectOne(int no);
	public int memberUpdateOne(MemberVo memberVo);
	
}

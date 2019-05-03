package com.edu.member.service;

import java.util.List;

import com.edu.member.vo.MemberVo;

public interface MemberService {

	
	
	
	public MemberVo memberExist(MemberVo memberVo);
	public void memberInsertOne(MemberVo memberVo);
	public MemberVo memberSelectOne(int no);
	public int memberUpdateOne(MemberVo memberVo);
	public int memberDeleteOne(int no);
	
	
	//관리자모드? 조회
	public List<MemberVo> memberSelectList(String searchOption,String keyword,int start, int end, String order);
	
	//페이징
	public int memberCountTotal(String searchOption, String keyword);
	
	public MemberVo memberExistCheck(MemberVo memberVo);
	
	
	
}

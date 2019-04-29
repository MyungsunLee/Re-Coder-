package com.edu.member.dao;

import java.util.List;
import java.util.Map;

import com.edu.member.vo.MemberVo;

public interface MemberDao {

		public MemberVo memberExist(MemberVo memberVo);
		public int memberInsertOne(MemberVo memberVo);
		public MemberVo memberSelectOne(int no);
		public int memberUpdateOne(MemberVo memberVo);
		public int memberDeleteOne(int no);
		
		//관리자모드? 조회
		public List<MemberVo> memberSelectList(String searchOption,String keyword,int start, int end, String order);
		
		
		//페이징
		public int memberCountTotal(Map<String, String> map);
		
}

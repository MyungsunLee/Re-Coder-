package com.edu.member.dao;

import java.util.List;
import java.util.Map;

import com.edu.member.vo.MemberVo;

public interface MemberDao {

		public MemberVo memberExist(Map<String, Object> paramMap);
		public int memberInsertOne(MemberVo memberVo);
		public MemberVo memberSelectOne(int no);
		public int memberUpdateOne(MemberVo memberVo);
		
}

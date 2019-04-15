package com.edu.member.dao;

import com.edu.member.vo.MemberVo;

public interface MemberDao {

		public MemberVo memberExist(MemberVo memberVo);
		public int memberInsertOne(MemberVo memberVo);
		public MemberVo memberSelectOne(int no);
		public int memberUpdateOne(MemberVo memberVo);
		
}

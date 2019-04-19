package com.edu.memberInfo.dao;

import java.util.List;

import com.edu.member.vo.MemberVo;
import com.edu.memberInfo.vo.MemberInfoVo;

public interface MemberInfoDao {

	
	
	public List<MemberInfoVo> memberInfoSelectList(String searchOption, String keyword, int start, int end);
	public MemberInfoVo memberInfoExist(MemberInfoVo memberInfoVo); 
//	public int memberInfoExist(MemberInfoVo memberInfoVo); // boolean 체크를 위해 int로 바꿈
	public int memberInfoInsertOne(MemberInfoVo memberInfoVo);
	public MemberInfoVo memberInfoSelectOne(int no);
	public int memberInfoUpdateOne(MemberInfoVo memberInfo);
}

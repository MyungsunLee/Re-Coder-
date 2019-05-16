package com.recoder.fatda.memberInfo.dao;

import java.util.List;

import com.recoder.fatda.memberInfo.vo.MemberInfoVo;

public interface MemberInfoDao {

	
	
	public List<MemberInfoVo> memberInfoSelectList(String searchOption, String keyword, int start, int end);
	public MemberInfoVo memberInfoExist(MemberInfoVo memberInfoVo); 
	public int memberInfoInsertOne(MemberInfoVo memberInfoVo);
	public MemberInfoVo memberInfoSelectOne(int no);
	public int memberInfoUpdateOne(MemberInfoVo memberInfoVo);
	public int memberInfoUpdateOneKCal(MemberInfoVo memberInfoVo);
}

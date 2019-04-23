package com.edu.memberInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.member.dao.MemberDao;
import com.edu.member.vo.MemberVo;
import com.edu.memberInfo.dao.MemberInfoDao;
import com.edu.memberInfo.vo.MemberInfoVo;

@Service
public class MemberInfoServiceImpl implements MemberInfoService {

	@Autowired
	public MemberInfoDao memberInfoDao;

	@Override
	public List<MemberInfoVo> memberInfoSelectList(String searchOption, String keyword, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean memberInfoExist(MemberInfoVo memberInfoVo) {
		// TODO Auto-generated method stub
		MemberInfoVo result = memberInfoDao.memberInfoExist(memberInfoVo);
		boolean check = false;
		
		if (result == null) {
			return check;
		} else {
			check = true;
		}
		
		
		return check;
	}

	@Override
	public int memberInfoInsertOne(MemberInfoVo memberInfoVo) {
		// TODO Auto-generated method stub
		return memberInfoDao.memberInfoInsertOne(memberInfoVo);
	}

	@Override
	public MemberInfoVo memberInfoSelectOne(int no) {
		// TODO Auto-generated method stub
		return memberInfoDao.memberInfoSelectOne(no);
	}

	@Override
	public int memberInfoUpdateOne(MemberInfoVo memberInfoVo) {
		// TODO Auto-generated method stub
		return memberInfoDao.memberInfoUpdateOne(memberInfoVo);
	}

	@Override
	public int memberInfoUpdateOneKCal(MemberInfoVo memberInfoVo) {
		// TODO Auto-generated method stub
		return memberInfoDao.memberInfoUpdateOneKCal(memberInfoVo);
	}


}
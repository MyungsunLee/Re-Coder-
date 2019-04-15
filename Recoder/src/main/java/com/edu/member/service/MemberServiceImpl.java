package com.edu.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.member.dao.MemberDao;
import com.edu.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	private final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	public MemberDao memberDao;



	@Override
	public MemberVo memberExist(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return memberDao.memberExist(paramMap);
	}

	@Override
	public void memberInsertOne(MemberVo memberVo) {
		// TODO Auto-generated method stub

		memberDao.memberInsertOne(memberVo);
	}

	@Override
	public Map<String, Object> memberSelectOne(int no) {
		// TODO Auto-generated method stub

		Map<String, Object> resultMap = new HashMap<String, Object>();

		MemberVo memberVo = memberDao.memberSelectOne(no);
		resultMap.put("memberVo", memberVo);

		return resultMap;
	}

	@Override
	public int memberUpdateOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		int resultNum = 0;

		resultNum = memberDao.memberUpdateOne(memberVo);

		return resultNum;
	}



}

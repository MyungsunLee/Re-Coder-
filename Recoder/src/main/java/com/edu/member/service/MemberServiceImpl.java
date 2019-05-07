package com.edu.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.member.dao.MemberDao;
import com.edu.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

//	private final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	public MemberDao memberDao;



	@Override
	public MemberVo memberExist(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return memberDao.memberExist(memberVo);
	}

	@Override
	public void memberInsertOne(MemberVo memberVo) {
		// TODO Auto-generated method stub

		memberDao.memberInsertOne(memberVo);
	}

	@Override
	public MemberVo memberSelectOne(int no) {
		// TODO Auto-generated method stub

		MemberVo memberVo = memberDao.memberSelectOne(no);

		return memberVo;
	}

	@Override
	public int memberUpdateOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		int resultNum = 0;

		resultNum = memberDao.memberUpdateOne(memberVo);

		return resultNum;
	}

	@Override
	public List<MemberVo> memberSelectList(String searchOption, String keyword, int start, int end, String order) {
		// TODO Auto-generated method stub
		return memberDao.memberSelectList(searchOption, keyword, start, end, order);
	}

	@Override
	public int memberCountTotal(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("sesarchOption", searchOption);
		map.put("keyword", keyword);
		
		
		return memberDao.memberCountTotal(map);
	}

	@Override
	public int memberDeleteOne(int no) {
		// TODO Auto-generated method stub
		return memberDao.memberDeleteOne(no);
	}

	@Override
	public MemberVo memberExistCheck(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return memberDao.memberExistCheck(memberVo);
	}



}

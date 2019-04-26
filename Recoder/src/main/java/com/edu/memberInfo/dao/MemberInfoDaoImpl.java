package com.edu.memberInfo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.memberInfo.vo.MemberInfoVo;


@Repository
public class MemberInfoDaoImpl implements MemberInfoDao {


	@Autowired
	SqlSessionTemplate sqlSession;
	
	String namespace = "com.edu.memberInfo.";
	
	@Override
	public List<MemberInfoVo> memberInfoSelectList(String searchOption, String keyword, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberInfoVo memberInfoExist(MemberInfoVo memberInfoVo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "memberInfoExist", memberInfoVo);
	}

	@Override
	public int memberInfoInsertOne(MemberInfoVo memberInfoVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "memberInfoInsertOne", memberInfoVo);
	}

	@Override
	public MemberInfoVo memberInfoSelectOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "memberInfoSelectOne", no);
	}

	@Override
	public int memberInfoUpdateOne(MemberInfoVo memberInfoVo) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "memberInfoUpdateOne", memberInfoVo);
	}

	@Override
	public int memberInfoUpdateOneKCal(MemberInfoVo memberInfoVo) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "memberInfoUpdateOneKCal", memberInfoVo);
	}


}

package com.edu.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.member.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	String namespace = "com.edu.member.";

	@Override
	public List<MemberVo> memberList() {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<>();

		return sqlSession.selectList(namespace + "memberSelectList", map);
	}

	@Override
	public MemberVo memberExist(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub

		return sqlSession.selectOne(namespace + "memberExist", paramMap);
	}

	@Override
	public int memberInsertOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "memberInsertOne", memberVo);
	}

	@Override
	public MemberVo memberSelectOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "memberSelectOne", no);
	}

	@Override
	public int memberUpdateOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "memberUpdateOne", memberVo);
	}

	@Override
	public int memberDelete(int no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + "memberDelete", no);
	}

}
